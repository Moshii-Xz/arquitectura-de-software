package com.agrointeligente.reportes.repository;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.reportes.entity.ReporteEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ReporteRepository extends JpaRepository<ReporteEntity, UUID> {

    List<ReporteEntity> findByDeletedAtIsNull();
}