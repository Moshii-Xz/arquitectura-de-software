package com.agrointeligente.insumos.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.insumos.dto.AplicacionInsumoCreateRequest;
import com.agrointeligente.insumos.dto.AplicacionInsumoResponse;
import com.agrointeligente.insumos.dto.AplicacionInsumoUpdateRequest;
import com.agrointeligente.insumos.dto.InsumoCreateRequest;
import com.agrointeligente.insumos.dto.InsumoResponse;
import com.agrointeligente.insumos.dto.InsumoUpdateRequest;

public interface InsumoService {

    List<InsumoResponse> findAll();

    InsumoResponse findById(UUID id);

    InsumoResponse create(InsumoCreateRequest request);

    InsumoResponse update(UUID id, InsumoUpdateRequest request);

    void delete(UUID id);

    List<AplicacionInsumoResponse> findAplicacionesByCultivo(UUID cultivoId);

    AplicacionInsumoResponse createAplicacion(UUID cultivoId, AplicacionInsumoCreateRequest request);

    AplicacionInsumoResponse updateAplicacion(UUID aplicacionId, AplicacionInsumoUpdateRequest request);

    void deleteAplicacion(UUID aplicacionId);
}