package com.agrointeligente.clima.service;

import java.util.UUID;

import com.agrointeligente.clima.dto.ClimaResponse;

public interface ClimaService {

    ClimaResponse consultarClimaPorCoordenadas(Double latitud, Double longitud);

    ClimaResponse consultarClimaDeCultivo(UUID cultivoId);
}