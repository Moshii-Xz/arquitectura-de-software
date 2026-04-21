package com.agrointeligente.usuario.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.usuario.dto.CambioPasswordRequest;
import com.agrointeligente.usuario.dto.PerfilResponse;
import com.agrointeligente.usuario.dto.PerfilUpdateRequest;
import com.agrointeligente.usuario.dto.UsuarioResponse;
import com.agrointeligente.usuario.dto.UsuarioUpdateRequest;

public interface UsuarioService {

    List<UsuarioResponse> findAll();

    UsuarioResponse findById(UUID id);

    UsuarioResponse update(UUID id, UsuarioUpdateRequest request);

    void delete(UUID id);

    void reactivate(UUID id);

    PerfilResponse getPerfil(UUID usuarioId);

    PerfilResponse updatePerfil(UUID usuarioId, PerfilUpdateRequest request);

    UsuarioResponse changePassword(UUID usuarioId, CambioPasswordRequest request);
}