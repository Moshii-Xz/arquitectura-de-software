package com.agrointeligente.insumos.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.agrointeligente.cultivos.entity.CultivoEntity;
import com.agrointeligente.cultivos.repository.CultivoRepository;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.insumos.dto.AplicacionInsumoCreateRequest;
import com.agrointeligente.insumos.dto.AplicacionInsumoResponse;
import com.agrointeligente.insumos.dto.AplicacionInsumoUpdateRequest;
import com.agrointeligente.insumos.dto.InsumoCreateRequest;
import com.agrointeligente.insumos.dto.InsumoResponse;
import com.agrointeligente.insumos.dto.InsumoUpdateRequest;
import com.agrointeligente.insumos.entity.AplicacionInsumoEntity;
import com.agrointeligente.insumos.entity.InsumoEntity;
import com.agrointeligente.insumos.repository.AplicacionInsumoRepository;
import com.agrointeligente.insumos.repository.InsumoRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class InsumoServiceImpl implements InsumoService {

    private final InsumoRepository insumoRepository;
    private final AplicacionInsumoRepository aplicacionInsumoRepository;
    private final CultivoRepository cultivoRepository;

    public InsumoServiceImpl(InsumoRepository insumoRepository, AplicacionInsumoRepository aplicacionInsumoRepository,
            CultivoRepository cultivoRepository) {
        this.insumoRepository = insumoRepository;
        this.aplicacionInsumoRepository = aplicacionInsumoRepository;
        this.cultivoRepository = cultivoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<InsumoResponse> findAll() {
        return insumoRepository.findByDeletedAtIsNull().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public InsumoResponse findById(UUID id) {
        return toResponse(getInsumo(id));
    }

    @Override
    public InsumoResponse create(InsumoCreateRequest request) {
        InsumoEntity insumo = new InsumoEntity();
        apply(insumo, request.nombre(), request.tipo(), request.unidad(), request.impactoAmbiental(),
                request.costoReferencia(), request.descripcion(), true);
        return toResponse(insumoRepository.save(insumo));
    }

    @Override
    public InsumoResponse update(UUID id, InsumoUpdateRequest request) {
        InsumoEntity insumo = getInsumo(id);
        apply(insumo, request.nombre(), request.tipo(), request.unidad(), request.impactoAmbiental(),
                request.costoReferencia(), request.descripcion(), request.activo() == null ? insumo.isActivo() : request.activo());
        return toResponse(insumoRepository.save(insumo));
    }

    @Override
    public void delete(UUID id) {
        InsumoEntity insumo = getInsumo(id);
        insumo.setActivo(false);
        insumo.setDeletedAt(LocalDateTime.now());
        insumoRepository.save(insumo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AplicacionInsumoResponse> findAplicacionesByCultivo(UUID cultivoId) {
        return aplicacionInsumoRepository.findByCultivoIdAndDeletedAtIsNull(cultivoId).stream().map(this::toResponse).toList();
    }

    @Override
    public AplicacionInsumoResponse createAplicacion(UUID cultivoId, AplicacionInsumoCreateRequest request) {
        CultivoEntity cultivo = cultivoRepository.findById(cultivoId)
                .orElseThrow(() -> new NotFoundException("Cultivo no encontrado: " + cultivoId));
        InsumoEntity insumo = getInsumo(request.insumoId());
        AplicacionInsumoEntity aplicacion = new AplicacionInsumoEntity();
        aplicacion.setCultivo(cultivo);
        aplicacion.setInsumo(insumo);
        aplicacion.setCantidad(request.cantidad());
        aplicacion.setCosto(request.costo());
        aplicacion.setUnidad(request.unidad() != null ? request.unidad() : insumo.getUnidad());
        aplicacion.setFechaAplicacion(request.fechaAplicacion());
        aplicacion.setObservaciones(request.observaciones());
        return toResponse(aplicacionInsumoRepository.save(aplicacion));
    }

    @Override
    public AplicacionInsumoResponse updateAplicacion(UUID aplicacionId, AplicacionInsumoUpdateRequest request) {
        AplicacionInsumoEntity aplicacion = getAplicacion(aplicacionId);
        if (aplicacion.getEditableHasta() != null && aplicacion.getEditableHasta().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La aplicación ya no se puede editar");
        }
        aplicacion.setCantidad(request.cantidad());
        aplicacion.setCosto(request.costo());
        aplicacion.setUnidad(request.unidad());
        aplicacion.setFechaAplicacion(request.fechaAplicacion());
        aplicacion.setObservaciones(request.observaciones());
        return toResponse(aplicacionInsumoRepository.save(aplicacion));
    }

    @Override
    public void deleteAplicacion(UUID aplicacionId) {
        AplicacionInsumoEntity aplicacion = getAplicacion(aplicacionId);
        if (aplicacion.getEditableHasta() != null && aplicacion.getEditableHasta().isBefore(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "La aplicación ya no se puede eliminar");
        }
        aplicacion.setDeletedAt(LocalDateTime.now());
        aplicacionInsumoRepository.save(aplicacion);
    }

    private InsumoEntity getInsumo(UUID id) {
        return insumoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Insumo no encontrado: " + id));
    }

    private AplicacionInsumoEntity getAplicacion(UUID id) {
        return aplicacionInsumoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Aplicación no encontrada: " + id));
    }

    private void apply(InsumoEntity insumo, String nombre, String tipo, String unidad, boolean impactoAmbiental,
            java.math.BigDecimal costoReferencia, String descripcion, boolean activo) {
        insumo.setNombre(nombre);
        insumo.setTipo(tipo);
        insumo.setUnidad(unidad);
        insumo.setImpactoAmbiental(impactoAmbiental);
        insumo.setCostoReferencia(costoReferencia);
        insumo.setDescripcion(descripcion);
        insumo.setActivo(activo);
    }

    private InsumoResponse toResponse(InsumoEntity insumo) {
        return new InsumoResponse(insumo.getId(), insumo.getNombre(), insumo.getTipo(), insumo.getUnidad(),
                insumo.isImpactoAmbiental(), insumo.getCostoReferencia(), insumo.getDescripcion(), insumo.isActivo(),
                insumo.getCreatedAt(), insumo.getUpdatedAt());
    }

    private AplicacionInsumoResponse toResponse(AplicacionInsumoEntity aplicacion) {
        return new AplicacionInsumoResponse(aplicacion.getId(), aplicacion.getCultivo().getId(),
                aplicacion.getInsumo().getId(), aplicacion.getInsumo().getNombre(), aplicacion.getCantidad(),
                aplicacion.getUnidad(), aplicacion.getCosto(), aplicacion.getFechaAplicacion(), aplicacion.getObservaciones(),
                aplicacion.getEditableHasta(), aplicacion.getCreatedAt(), aplicacion.getUpdatedAt());
    }
}