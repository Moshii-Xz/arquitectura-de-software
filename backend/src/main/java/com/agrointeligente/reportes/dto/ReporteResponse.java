package com.agrointeligente.reportes.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record ReporteResponse(
        UUID id,
        UUID usuarioId,
        String tipo,
        LocalDate periodoInicio,
        LocalDate periodoFin,
        String formato,
        String estado,
        String urlArchivo,
        String resumen,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}