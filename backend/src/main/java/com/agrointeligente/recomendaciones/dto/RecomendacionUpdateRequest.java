package com.agrointeligente.recomendaciones.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RecomendacionUpdateRequest(
        @NotBlank @Size(max = 80) String tipo,
        @NotBlank @Size(max = 20) String prioridad,
        @Size(max = 150) String titulo,
        @NotBlank @Size(max = 2000) String justificacion,
        @Size(max = 20) String estado) {
}