package com.agrointeligente.backend.auth.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequest {

    @NotBlank(message = "Email es requerido")
    @Email(message = "Email debe ser valido")
    private String email;

    @NotBlank(message = "Contrasena es requerida")
    @Size(min = 6, max = 255, message = "Contrasena debe tener entre 6 y 255 caracteres")
    private String password;
}
