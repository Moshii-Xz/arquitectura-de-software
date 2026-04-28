package com.agrointeligente.backend.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserProfileDto {

    private Long id;

    @Size(max = 100, message = "Nombre debe tener maximo 100 caracteres")
    private String firstName;

    @Size(max = 100, message = "Apellido debe tener maximo 100 caracteres")
    private String lastName;

    @Size(max = 20, message = "Numero de telefono debe tener maximo 20 caracteres")
    private String phoneNumber;

    @Size(max = 100, message = "Municipio debe tener maximo 100 caracteres")
    private String municipality;

    @Size(max = 255, message = "Nombre de finca debe tener maximo 255 caracteres")
    private String farmName;

    @Size(max = 10, message = "Idioma debe tener maximo 10 caracteres")
    private String language;

    private String photoUrl;
}
