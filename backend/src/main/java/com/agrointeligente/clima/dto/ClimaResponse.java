package com.agrointeligente.clima.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ClimaResponse(
        Double temperatura,
        Double humedad,
        Double precipitacion,
        Double viento,
        String resumen,
        List<String> pronostico,
        LocalDateTime actualizacion) {
}