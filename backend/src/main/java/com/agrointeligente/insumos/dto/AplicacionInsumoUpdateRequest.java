package com.agrointeligente.insumos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AplicacionInsumoUpdateRequest(
        @NotNull @Positive BigDecimal cantidad,
        BigDecimal costo,
        String unidad,
        @NotNull LocalDateTime fechaAplicacion,
        String observaciones) {
}