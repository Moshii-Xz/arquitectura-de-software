package com.agrointeligente.backend.auth.dto;

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
public class ChangePasswordRequest {

    @NotBlank(message = "Contrasena actual es requerida")
    private String oldPassword;

    @NotBlank(message = "Nueva contrasena es requerida")
    @Size(min = 6, max = 255, message = "Nueva contrasena debe tener entre 6 y 255 caracteres")
    private String newPassword;

    @NotBlank(message = "Confirmacion es requerida")
    private String confirmPassword;
}
