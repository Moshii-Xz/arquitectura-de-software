package com.agrointeligente.insumos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record AplicacionInsumoCreateRequest(
        @NotNull UUID insumoId,
        @NotNull @Positive BigDecimal cantidad,
        BigDecimal costo,
        String unidad,
        @NotNull LocalDateTime fechaAplicacion,
        String observaciones) {
}