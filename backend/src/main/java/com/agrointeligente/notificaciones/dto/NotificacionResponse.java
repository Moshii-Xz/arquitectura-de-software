package com.agrointeligente.notificaciones.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record NotificacionResponse(
        UUID id,
        UUID usuarioId,
        String tipo,
        String mensaje,
        boolean leida,
        LocalDateTime fecha) {
}