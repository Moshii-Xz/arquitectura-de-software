package com.agrointeligente.usuario.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CambioPasswordRequest(
        @NotBlank @Size(min = 8, max = 120) String passwordActual,
        @NotBlank @Size(min = 8, max = 120) String passwordNueva) {
}