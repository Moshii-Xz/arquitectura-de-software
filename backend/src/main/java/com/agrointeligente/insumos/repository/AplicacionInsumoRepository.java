package com.agrointeligente.insumos.repository;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.insumos.entity.AplicacionInsumoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicacionInsumoRepository extends JpaRepository<AplicacionInsumoEntity, UUID> {

    List<AplicacionInsumoEntity> findByCultivoIdAndDeletedAtIsNull(UUID cultivoId);
}