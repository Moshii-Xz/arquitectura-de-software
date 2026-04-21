package com.agrointeligente.cultivos.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.cultivos.dto.CultivoCreateRequest;
import com.agrointeligente.cultivos.dto.CultivoResponse;
import com.agrointeligente.cultivos.dto.CultivoUpdateRequest;
import com.agrointeligente.cultivos.entity.CultivoEntity;
import com.agrointeligente.cultivos.repository.CultivoRepository;
import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.repository.UserRepository;
import com.agrointeligente.exception.NotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Service
@SuppressWarnings("null")
@Transactional
public class CultivoServiceImpl implements CultivoService {

    private final CultivoRepository cultivoRepository;
    private final UserRepository userRepository;

    public CultivoServiceImpl(CultivoRepository cultivoRepository, UserRepository userRepository) {
        this.cultivoRepository = cultivoRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<CultivoResponse> findAll() {
        return cultivoRepository.findByDeletedAtIsNull().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CultivoResponse findById(UUID id) {
        return cultivoRepository.findById(id).filter(cultivo -> cultivo.getDeletedAt() == null).map(this::toResponse)
                .orElseThrow(() -> new NotFoundException("Cultivo no encontrado: " + id));
    }

    @Override
    public CultivoResponse create(CultivoCreateRequest request) {
        UserEntity usuario = userRepository.findById(request.usuarioId())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado: " + request.usuarioId()));

        CultivoEntity cultivo = new CultivoEntity();
        applyRequest(cultivo, request.tipoCultivo(), request.nombreLote(), request.areaHectareas(), request.variedad(),
                request.fechaSiembra(), request.fechaCosechaEstimada(), request.fechaCosechaReal(), request.municipio(),
                request.vereda(), request.estado());
        cultivo.setUsuario(usuario);
        if (cultivo.getEstado() == null || cultivo.getEstado().isBlank()) {
            cultivo.setEstado("ACTIVO");
        }

        return toResponse(cultivoRepository.save(cultivo));
    }

    @Override
    public CultivoResponse update(UUID id, CultivoUpdateRequest request) {
        CultivoEntity cultivo = cultivoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cultivo no encontrado: " + id));

        applyRequest(cultivo, request.tipoCultivo(), request.nombreLote(), request.areaHectareas(), request.variedad(),
                request.fechaSiembra(), request.fechaCosechaEstimada(), request.fechaCosechaReal(), request.municipio(),
                request.vereda(), request.estado());
        if (cultivo.getEstado() == null || cultivo.getEstado().isBlank()) {
            cultivo.setEstado("ACTIVO");
        }

        return toResponse(cultivoRepository.save(cultivo));
    }

    @Override
    public void delete(UUID id) {
        CultivoEntity cultivo = cultivoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cultivo no encontrado: " + id));
        cultivo.setEstado("ARCHIVADO");
        cultivo.setDeletedAt(java.time.LocalDateTime.now());
        cultivoRepository.save(cultivo);
    }

    private void applyRequest(CultivoEntity cultivo, String tipoCultivo, String nombreLote,
            java.math.BigDecimal areaHectareas, String variedad, java.time.LocalDate fechaSiembra,
            java.time.LocalDate fechaCosechaEstimada, java.time.LocalDate fechaCosechaReal, String municipio,
            String vereda, String estado) {
        cultivo.setTipoCultivo(tipoCultivo);
        cultivo.setNombreLote(nombreLote);
        cultivo.setAreaHectareas(areaHectareas);
        cultivo.setVariedad(variedad);
        cultivo.setFechaSiembra(fechaSiembra);
        cultivo.setFechaCosechaEstimada(fechaCosechaEstimada);
        cultivo.setFechaCosechaReal(fechaCosechaReal);
        cultivo.setMunicipio(municipio);
        cultivo.setVereda(vereda);
        cultivo.setEstado(estado);
    }

    private CultivoResponse toResponse(CultivoEntity cultivo) {
        return new CultivoResponse(
                cultivo.getId(),
                cultivo.getUsuario().getId(),
                cultivo.getTipoCultivo(),
                cultivo.getNombreLote(),
                cultivo.getAreaHectareas(),
                cultivo.getVariedad(),
                cultivo.getFechaSiembra(),
                cultivo.getFechaCosechaEstimada(),
                cultivo.getFechaCosechaReal(),
                cultivo.getMunicipio(),
                cultivo.getVereda(),
                cultivo.getEstado(),
                cultivo.getCreatedAt(),
                cultivo.getUpdatedAt());
    }
}