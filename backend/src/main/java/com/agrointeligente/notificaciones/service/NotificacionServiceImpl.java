package com.agrointeligente.notificaciones.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.notificaciones.dto.NotificacionCreateRequest;
import com.agrointeligente.notificaciones.dto.NotificacionResponse;
import com.agrointeligente.notificaciones.entity.NotificacionEntity;
import com.agrointeligente.notificaciones.repository.NotificacionRepository;
import com.agrointeligente.repository.UserRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class NotificacionServiceImpl implements NotificacionService {

    private final NotificacionRepository notificacionRepository;
    private final UserRepository userRepository;

    public NotificacionServiceImpl(NotificacionRepository notificacionRepository, UserRepository userRepository) {
        this.notificacionRepository = notificacionRepository;
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificacionResponse> findAll() {
        return notificacionRepository.findByDeletedAtIsNullOrderByFechaDesc().stream().map(this::toResponse).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<NotificacionResponse> findByUsuario(UUID usuarioId) {
        return notificacionRepository.findByUsuarioIdAndDeletedAtIsNullOrderByFechaDesc(usuarioId).stream().map(this::toResponse).toList();
    }

    @Override
    public NotificacionResponse create(NotificacionCreateRequest request) {
        UserEntity usuario = userRepository.findById(request.usuarioId())
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado: " + request.usuarioId()));
        NotificacionEntity notificacion = new NotificacionEntity();
        notificacion.setUsuario(usuario);
        notificacion.setTipo(request.tipo());
        notificacion.setMensaje(request.mensaje());
        return toResponse(notificacionRepository.save(notificacion));
    }

    @Override
    public NotificacionResponse marcarLeida(UUID id) {
        NotificacionEntity notificacion = getNotificacion(id);
        notificacion.setLeida(true);
        return toResponse(notificacionRepository.save(notificacion));
    }

    @Override
    public void delete(UUID id) {
        NotificacionEntity notificacion = getNotificacion(id);
        notificacion.setDeletedAt(java.time.LocalDateTime.now());
        notificacionRepository.save(notificacion);
    }

    private NotificacionEntity getNotificacion(UUID id) {
        return notificacionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Notificación no encontrada: " + id));
    }

    private NotificacionResponse toResponse(NotificacionEntity notificacion) {
        return new NotificacionResponse(notificacion.getId(), notificacion.getUsuario().getId(), notificacion.getTipo(),
                notificacion.getMensaje(), notificacion.isLeida(), notificacion.getFecha());
    }
}