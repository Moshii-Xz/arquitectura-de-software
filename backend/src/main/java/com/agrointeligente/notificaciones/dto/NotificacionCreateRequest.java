package com.agrointeligente.notificaciones.dto;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record NotificacionCreateRequest(
        @NotNull UUID usuarioId,
        @NotBlank @Size(max = 80) String tipo,
        @NotBlank @Size(max = 2000) String mensaje) {
}