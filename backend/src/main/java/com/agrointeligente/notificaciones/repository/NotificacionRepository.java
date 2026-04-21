package com.agrointeligente.notificaciones.repository;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.notificaciones.entity.NotificacionEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificacionRepository extends JpaRepository<NotificacionEntity, UUID> {

    List<NotificacionEntity> findByDeletedAtIsNullOrderByFechaDesc();

    List<NotificacionEntity> findByUsuarioIdAndDeletedAtIsNullOrderByFechaDesc(UUID usuarioId);
}