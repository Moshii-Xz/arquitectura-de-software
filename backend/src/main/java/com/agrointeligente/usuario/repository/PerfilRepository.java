package com.agrointeligente.usuario.repository;

import java.util.Optional;
import java.util.UUID;

import com.agrointeligente.usuario.entity.PerfilEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PerfilRepository extends JpaRepository<PerfilEntity, UUID> {

    Optional<PerfilEntity> findByUsuarioId(UUID usuarioId);
}