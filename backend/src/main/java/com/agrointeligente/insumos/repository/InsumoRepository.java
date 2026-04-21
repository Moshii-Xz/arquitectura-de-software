package com.agrointeligente.insumos.repository;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.insumos.entity.InsumoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InsumoRepository extends JpaRepository<InsumoEntity, UUID> {

    List<InsumoEntity> findByDeletedAtIsNull();
}