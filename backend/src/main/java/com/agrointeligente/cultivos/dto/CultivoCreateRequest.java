package com.agrointeligente.cultivos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CultivoCreateRequest(
        @NotNull UUID usuarioId,
        @NotBlank @Size(max = 80) String tipoCultivo,
        @Size(max = 150) String nombreLote,
        @NotNull @DecimalMin(value = "0.00", inclusive = false) BigDecimal areaHectareas,
        @Size(max = 120) String variedad,
        @NotNull LocalDate fechaSiembra,
        LocalDate fechaCosechaEstimada,
        LocalDate fechaCosechaReal,
        @Size(max = 120) String municipio,
        @Size(max = 120) String vereda,
        @Size(max = 20) String estado) {
}