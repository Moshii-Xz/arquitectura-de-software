package com.agrointeligente.insumos.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record InsumoUpdateRequest(
        @NotBlank @Size(max = 120) String nombre,
        @NotBlank @Size(max = 80) String tipo,
        @Size(max = 60) String unidad,
        @NotNull Boolean impactoAmbiental,
        BigDecimal costoReferencia,
        @Size(max = 500) String descripcion,
        Boolean activo) {
}