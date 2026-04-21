package com.agrointeligente.usuario.dto;

import jakarta.validation.constraints.Size;

public record PerfilUpdateRequest(
        @Size(max = 120) String municipio,
        @Size(max = 120) String vereda,
        @Size(max = 120) String finca,
        @Size(max = 20) String telefono,
        @Size(max = 20) String idioma,
        @Size(max = 500) String fotoUrl,
        Double latitud,
        Double longitud,
        Boolean notificacionPush,
        Boolean notificacionEmail,
        Boolean notificacionSms) {
}