package com.agrointeligente.recomendaciones.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.recomendaciones.dto.RecomendacionCreateRequest;
import com.agrointeligente.recomendaciones.dto.RecomendacionResponse;
import com.agrointeligente.recomendaciones.dto.RecomendacionUpdateRequest;

public interface RecomendacionService {

    List<RecomendacionResponse> findAll();

    RecomendacionResponse findById(UUID id);

    RecomendacionResponse create(RecomendacionCreateRequest request);

    RecomendacionResponse update(UUID id, RecomendacionUpdateRequest request);

    void delete(UUID id);

    List<RecomendacionResponse> findActivas(UUID cultivoId);

    List<RecomendacionResponse> findHistorico(UUID cultivoId);

    RecomendacionResponse marcarAtendida(UUID id);

    RecomendacionResponse descartar(UUID id);
}