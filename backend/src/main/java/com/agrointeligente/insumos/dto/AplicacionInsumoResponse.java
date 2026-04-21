package com.agrointeligente.insumos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record AplicacionInsumoResponse(
        UUID id,
        UUID cultivoId,
        UUID insumoId,
        String insumoNombre,
        BigDecimal cantidad,
        String unidad,
        BigDecimal costo,
        LocalDateTime fechaAplicacion,
        String observaciones,
        LocalDateTime editableHasta,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}