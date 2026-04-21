package com.agrointeligente.reportes.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.reportes.dto.ReporteCreateRequest;
import com.agrointeligente.reportes.dto.ReporteResponse;

public interface ReporteService {

    List<ReporteResponse> findAll();

    ReporteResponse findById(UUID id);

    ReporteResponse create(ReporteCreateRequest request);

    void delete(UUID id);
}