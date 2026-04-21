package com.agrointeligente.cultivos.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.cultivos.dto.CultivoCreateRequest;
import com.agrointeligente.cultivos.dto.CultivoResponse;
import com.agrointeligente.cultivos.dto.CultivoUpdateRequest;

public interface CultivoService {

    List<CultivoResponse> findAll();

    CultivoResponse findById(UUID id);

    CultivoResponse create(CultivoCreateRequest request);

    CultivoResponse update(UUID id, CultivoUpdateRequest request);

    void delete(UUID id);
}