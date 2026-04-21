package com.agrointeligente.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegistroRequest(
        @NotBlank @Size(max = 20) String documento,
        @NotBlank @Size(max = 120) String nombres,
        @Size(max = 120) String apellidos,
        @NotBlank @Size(max = 20) String telefono,
        @NotBlank @Size(max = 120) String municipio,
        @Size(max = 120) String vereda,
        @Email @Size(max = 150) String email,
        @NotBlank @Size(min = 8, max = 120) String password) {
}