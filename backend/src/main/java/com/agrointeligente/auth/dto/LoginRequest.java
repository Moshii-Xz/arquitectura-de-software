package com.agrointeligente.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LoginRequest(
        @NotBlank @Size(max = 150) String identificador,
        @NotBlank @Size(min = 8, max = 120) String password) {
}