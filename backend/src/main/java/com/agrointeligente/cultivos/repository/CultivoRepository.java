package com.agrointeligente.cultivos.repository;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.cultivos.entity.CultivoEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CultivoRepository extends JpaRepository<CultivoEntity, UUID> {

	List<CultivoEntity> findByDeletedAtIsNull();

	List<CultivoEntity> findByUsuarioIdAndDeletedAtIsNull(UUID usuarioId);
}