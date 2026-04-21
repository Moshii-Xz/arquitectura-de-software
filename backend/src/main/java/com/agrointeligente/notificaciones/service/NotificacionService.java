package com.agrointeligente.notificaciones.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.notificaciones.dto.NotificacionCreateRequest;
import com.agrointeligente.notificaciones.dto.NotificacionResponse;

public interface NotificacionService {

    List<NotificacionResponse> findAll();

    List<NotificacionResponse> findByUsuario(UUID usuarioId);

    NotificacionResponse create(NotificacionCreateRequest request);

    NotificacionResponse marcarLeida(UUID id);

    void delete(UUID id);
}