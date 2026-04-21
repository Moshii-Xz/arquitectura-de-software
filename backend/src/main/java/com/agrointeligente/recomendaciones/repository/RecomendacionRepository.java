package com.agrointeligente.recomendaciones.repository;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.recomendaciones.entity.RecomendacionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecomendacionRepository extends JpaRepository<RecomendacionEntity, UUID> {

    List<RecomendacionEntity> findByDeletedAtIsNull();

    List<RecomendacionEntity> findByCultivoIdAndDeletedAtIsNull(UUID cultivoId);

    List<RecomendacionEntity> findByEstadoAndDeletedAtIsNull(String estado);
}