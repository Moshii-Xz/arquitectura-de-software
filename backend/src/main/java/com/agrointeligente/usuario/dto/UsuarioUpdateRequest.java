package com.agrointeligente.usuario.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioUpdateRequest(
        @NotBlank @Size(max = 120) String nombres,
        @Size(max = 120) String apellidos,
        @NotBlank @Size(max = 20) String telefono,
        @Email @Size(max = 150) String email,
        @Size(max = 50) String rol,
        Boolean activo) {
}