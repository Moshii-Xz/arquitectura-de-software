package com.agrointeligente.usuario.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record PerfilResponse(
        UUID id,
        String municipio,
        String vereda,
        String finca,
        String telefono,
        String idioma,
        String fotoUrl,
        Double latitud,
        Double longitud,
        boolean notificacionPush,
        boolean notificacionEmail,
        boolean notificacionSms,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}