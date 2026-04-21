package com.agrointeligente.cultivos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record CultivoResponse(
        UUID id,
        UUID usuarioId,
        String tipoCultivo,
        String nombreLote,
        BigDecimal areaHectareas,
        String variedad,
        LocalDate fechaSiembra,
        LocalDate fechaCosechaEstimada,
        LocalDate fechaCosechaReal,
        String municipio,
        String vereda,
        String estado,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}