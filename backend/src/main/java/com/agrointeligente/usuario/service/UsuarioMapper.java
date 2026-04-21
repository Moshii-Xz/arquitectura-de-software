package com.agrointeligente.usuario.service;

import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.usuario.dto.PerfilResponse;
import com.agrointeligente.usuario.dto.UsuarioResponse;
import com.agrointeligente.usuario.entity.PerfilEntity;

import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioResponse toResponse(UserEntity usuario) {
        return toResponse(usuario, null);
    }

    public UsuarioResponse toResponse(UserEntity usuario, PerfilEntity perfilEntity) {
        PerfilResponse perfil = perfilEntity == null ? null : toPerfilResponse(perfilEntity);
        return new UsuarioResponse(
                usuario.getId(),
                usuario.getDocumento(),
                usuario.getNombres(),
                usuario.getApellidos(),
                usuario.getTelefono(),
                usuario.getEmail(),
                usuario.getRol(),
                usuario.isActivo(),
                usuario.getUltimoAcceso(),
                perfil,
                usuario.getCreatedAt(),
                usuario.getUpdatedAt());
    }

    public PerfilResponse toPerfilResponse(PerfilEntity perfil) {
        return new PerfilResponse(
                perfil.getId(),
                perfil.getMunicipio(),
                perfil.getVereda(),
                perfil.getFinca(),
                perfil.getTelefono(),
                perfil.getIdioma(),
                perfil.getFotoUrl(),
                perfil.getLatitud(),
                perfil.getLongitud(),
                perfil.isNotificacionPush(),
                perfil.isNotificacionEmail(),
                perfil.isNotificacionSms(),
                perfil.getCreatedAt(),
                perfil.getUpdatedAt());
    }
}