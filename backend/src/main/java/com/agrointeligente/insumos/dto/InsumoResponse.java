package com.agrointeligente.insumos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record InsumoResponse(
        UUID id,
        String nombre,
        String tipo,
        String unidad,
        boolean impactoAmbiental,
        BigDecimal costoReferencia,
        String descripcion,
        boolean activo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}