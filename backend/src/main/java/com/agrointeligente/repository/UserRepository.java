package com.agrointeligente.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agrointeligente.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {

	Optional<UserEntity> findByDocumento(String documento);

	Optional<UserEntity> findByTelefono(String telefono);

	Optional<UserEntity> findByEmail(String email);

	boolean existsByDocumento(String documento);
}