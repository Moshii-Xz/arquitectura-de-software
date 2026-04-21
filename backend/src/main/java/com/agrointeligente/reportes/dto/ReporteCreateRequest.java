package com.agrointeligente.reportes.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record ReporteCreateRequest(
        @NotNull UUID usuarioId,
        @NotBlank @Size(max = 80) String tipo,
        LocalDate periodoInicio,
        LocalDate periodoFin,
        @Size(max = 20) String formato,
        @Size(max = 500) String urlArchivo,
        @Size(max = 2000) String resumen) {
}