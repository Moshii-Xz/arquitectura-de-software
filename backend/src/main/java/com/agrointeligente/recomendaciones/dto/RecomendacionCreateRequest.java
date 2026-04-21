package com.agrointeligente.recomendaciones.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RecomendacionCreateRequest(
        @NotNull UUID cultivoId,
        @NotBlank @Size(max = 80) String tipo,
        @NotBlank @Size(max = 20) String prioridad,
        @Size(max = 150) String titulo,
        @NotBlank @Size(max = 2000) String justificacion,
        String estado) {
}