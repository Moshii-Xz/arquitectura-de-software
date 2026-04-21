package com.agrointeligente.recomendaciones.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.agrointeligente.cultivos.entity.CultivoEntity;
import com.agrointeligente.cultivos.repository.CultivoRepository;
import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.recomendaciones.dto.RecomendacionCreateRequest;
import com.agrointeligente.recomendaciones.dto.RecomendacionResponse;
import com.agrointeligente.recomendaciones.dto.RecomendacionUpdateRequest;
import com.agrointeligente.recomendaciones.entity.RecomendacionEntity;
import com.agrointeligente.recomendaciones.repository.RecomendacionRepository;
import com.agrointeligente.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class RecomendacionServiceImpl implements RecomendacionService {

    private final RecomendacionRepository recomendacionRepository;
    private final CultivoRepository cultivoRepository;
    private final UserRepository userRepository;

    public RecomendacionServiceImpl(RecomendacionRepository recomendacionRepository, CultivoRepository cultivoRepository,
            UserRepository userRepository) {
        this.recomendacionRepository = recomendacionRepository;
        this.cultivoRepository = cultivoRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecomendacionResponse> findAll() {
        return recomendacionRepository.findByDeletedAtIsNull().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public RecomendacionResponse findById(UUID id) {
        return toResponse(getRecomendacion(id));
    }

    @Override
    public RecomendacionResponse create(RecomendacionCreateRequest request) {
        CultivoEntity cultivo = cultivoRepository.findById(request.cultivoId())
            .orElseThrow(() -> new NotFoundException("Cultivo no encontrado: " + request.cultivoId()));
        UserEntity usuario = cultivo.getUsuario();

        RecomendacionEntity recomendacion = new RecomendacionEntity();
        recomendacion.setCultivo(cultivo);
        recomendacion.setUsuario(usuario);
        recomendacion.setTipo(request.tipo());
        recomendacion.setPrioridad(request.prioridad());
        recomendacion.setTitulo(request.titulo());
        recomendacion.setJustificacion(request.justificacion());
        recomendacion.setEstado(request.estado() == null || request.estado().isBlank() ? "PENDIENTE" : request.estado());
        recomendacion.setFechaGeneracion(LocalDateTime.now());
        return toResponse(recomendacionRepository.save(recomendacion));
    }

    @Override
    public RecomendacionResponse update(UUID id, RecomendacionUpdateRequest request) {
        RecomendacionEntity recomendacion = getRecomendacion(id);
        recomendacion.setTipo(request.tipo());
        recomendacion.setPrioridad(request.prioridad());
        recomendacion.setTitulo(request.titulo());
        recomendacion.setJustificacion(request.justificacion());
        if (request.estado() != null && !request.estado().isBlank()) {
            recomendacion.setEstado(request.estado());
        }
        return toResponse(recomendacionRepository.save(recomendacion));
    }

    @Override
    public void delete(UUID id) {
        RecomendacionEntity recomendacion = getRecomendacion(id);
        recomendacion.setDeletedAt(LocalDateTime.now());
        recomendacionRepository.save(recomendacion);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecomendacionResponse> findActivas(UUID cultivoId) {
        if (cultivoId != null) {
            return recomendacionRepository.findByCultivoIdAndDeletedAtIsNull(cultivoId).stream()
                    .filter(recomendacion -> !"DESCARTADA".equalsIgnoreCase(recomendacion.getEstado()))
                    .map(this::toResponse)
                    .toList();
        }
        return recomendacionRepository.findByDeletedAtIsNull().stream()
                .filter(recomendacion -> !"DESCARTADA".equalsIgnoreCase(recomendacion.getEstado()))
                .map(this::toResponse)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<RecomendacionResponse> findHistorico(UUID cultivoId) {
        if (cultivoId != null) {
            return recomendacionRepository.findByCultivoIdAndDeletedAtIsNull(cultivoId).stream().map(this::toResponse).toList();
        }
        return recomendacionRepository.findByDeletedAtIsNull().stream().map(this::toResponse).toList();
    }

    @Override
    public RecomendacionResponse marcarAtendida(UUID id) {
        RecomendacionEntity recomendacion = getRecomendacion(id);
        recomendacion.setEstado("APLICADA");
        recomendacion.setFechaAtencion(LocalDateTime.now());
        return toResponse(recomendacionRepository.save(recomendacion));
    }

    @Override
    public RecomendacionResponse descartar(UUID id) {
        RecomendacionEntity recomendacion = getRecomendacion(id);
        recomendacion.setEstado("DESCARTADA");
        recomendacion.setFechaAtencion(LocalDateTime.now());
        return toResponse(recomendacionRepository.save(recomendacion));
    }

    private RecomendacionEntity getRecomendacion(UUID id) {
        return recomendacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Recomendación no encontrada: " + id));
    }

    private RecomendacionResponse toResponse(RecomendacionEntity recomendacion) {
        return new RecomendacionResponse(recomendacion.getId(), recomendacion.getCultivo().getId(),
                recomendacion.getUsuario().getId(), recomendacion.getTipo(), recomendacion.getPrioridad(),
                recomendacion.getTitulo(), recomendacion.getJustificacion(), recomendacion.getEstado(),
                recomendacion.getFechaGeneracion(), recomendacion.getFechaAtencion(), recomendacion.getCreatedAt(),
                recomendacion.getUpdatedAt());
    }
}