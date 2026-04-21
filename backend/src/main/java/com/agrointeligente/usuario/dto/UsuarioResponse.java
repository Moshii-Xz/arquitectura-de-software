package com.agrointeligente.usuario.dto;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsuarioResponse(
        UUID id,
        String documento,
        String nombres,
        String apellidos,
        String telefono,
        String email,
        String rol,
        boolean activo,
        LocalDateTime ultimoAcceso,
        PerfilResponse perfil,
        LocalDateTime createdAt,
        LocalDateTime updatedAt) {
}