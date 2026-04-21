package com.agrointeligente.recomendaciones.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record RecomendacionResponse(
        UUID id,
        UUID cultivoId,
        UUID usuarioId,
        String tipo,
        String prioridad,
        String titulo,
        String justificacion,
        String estado,
        LocalDateTime fechaGeneracion,
        LocalDateTime fechaAtencion,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}