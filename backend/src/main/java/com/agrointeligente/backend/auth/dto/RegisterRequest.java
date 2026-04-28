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
public class RegisterRequest {

    @NotBlank(message = "Username es requerido")
    @Size(min = 3, max = 100, message = "Username debe tener entre 3 y 100 caracteres")
    private String username;

    @NotBlank(message = "Email es requerido")
    @Email(message = "Email debe ser valido")
    private String email;

    @NotBlank(message = "Contrasena es requerida")
    @Size(min = 6, max = 255, message = "Contrasena debe tener entre 6 y 255 caracteres")
    private String password;

    @NotBlank(message = "Confirmacion de contrasena es requerida")
    private String passwordConfirm;

    @NotBlank(message = "Nombre es requerido")
    @Size(min = 2, max = 100, message = "Nombre debe tener entre 2 y 100 caracteres")
    private String firstName;

    @NotBlank(message = "Apellido es requerido")
    @Size(min = 2, max = 100, message = "Apellido debe tener entre 2 y 100 caracteres")
    private String lastName;
}
