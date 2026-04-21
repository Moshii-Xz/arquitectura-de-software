package com.agrointeligente.auth.dto;

import java.time.Instant;

import com.agrointeligente.usuario.dto.UsuarioResponse;

public record AuthResponse(
        String accessToken,
        String tokenType,
        Instant expiresAt,
        UsuarioResponse usuario) {
}