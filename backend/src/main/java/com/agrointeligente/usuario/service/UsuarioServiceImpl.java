package com.agrointeligente.usuario.service;

import java.util.List;
import java.util.UUID;

import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.repository.UserRepository;
import com.agrointeligente.usuario.dto.CambioPasswordRequest;
import com.agrointeligente.usuario.dto.PerfilResponse;
import com.agrointeligente.usuario.dto.PerfilUpdateRequest;
import com.agrointeligente.usuario.dto.UsuarioResponse;
import com.agrointeligente.usuario.dto.UsuarioUpdateRequest;
import com.agrointeligente.usuario.entity.PerfilEntity;
import com.agrointeligente.usuario.repository.PerfilRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    private final UserRepository userRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;
    private final UsuarioMapper usuarioMapper;

    public UsuarioServiceImpl(UserRepository userRepository, PerfilRepository perfilRepository,
            PasswordEncoder passwordEncoder, UsuarioMapper usuarioMapper) {
        this.userRepository = userRepository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UsuarioResponse> findAll() {
        return userRepository.findAll().stream().map(this::mapWithPerfil).toList();
    }

    @Override
    @Transactional(readOnly = true)
    public UsuarioResponse findById(UUID id) {
        return mapWithPerfil(getUsuario(id));
    }

    @Override
    public UsuarioResponse update(UUID id, UsuarioUpdateRequest request) {
        UserEntity usuario = getUsuario(id);
        usuario.setNombres(request.nombres());
        usuario.setApellidos(request.apellidos());
        usuario.setTelefono(request.telefono());
        usuario.setEmail(request.email());
        if (request.rol() != null && !request.rol().isBlank()) {
            usuario.setRol(request.rol());
        }
        if (request.activo() != null) {
            usuario.setActivo(request.activo());
        }
        return mapWithPerfil(userRepository.save(usuario));
    }

    @Override
    public void delete(UUID id) {
        UserEntity usuario = getUsuario(id);
        usuario.setActivo(false);
        userRepository.save(usuario);
    }

    @Override
    public void reactivate(UUID id) {
        UserEntity usuario = getUsuario(id);
        usuario.setActivo(true);
        usuario.setBloqueadoHasta(null);
        usuario.setIntentosFallidos(0);
        userRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = true)
    public PerfilResponse getPerfil(UUID usuarioId) {
        return usuarioMapper.toPerfilResponse(getPerfilEntity(usuarioId));
    }

    @Override
    public PerfilResponse updatePerfil(UUID usuarioId, PerfilUpdateRequest request) {
        PerfilEntity perfil = getPerfilEntity(usuarioId);
        if (request.municipio() != null) {
            perfil.setMunicipio(request.municipio());
        }
        if (request.vereda() != null) {
            perfil.setVereda(request.vereda());
        }
        if (request.finca() != null) {
            perfil.setFinca(request.finca());
        }
        if (request.telefono() != null) {
            perfil.setTelefono(request.telefono());
        }
        if (request.idioma() != null) {
            perfil.setIdioma(request.idioma());
        }
        if (request.fotoUrl() != null) {
            perfil.setFotoUrl(request.fotoUrl());
        }
        if (request.latitud() != null) {
            perfil.setLatitud(request.latitud());
        }
        if (request.longitud() != null) {
            perfil.setLongitud(request.longitud());
        }
        if (request.notificacionPush() != null) {
            perfil.setNotificacionPush(request.notificacionPush());
        }
        if (request.notificacionEmail() != null) {
            perfil.setNotificacionEmail(request.notificacionEmail());
        }
        if (request.notificacionSms() != null) {
            perfil.setNotificacionSms(request.notificacionSms());
        }
        return usuarioMapper.toPerfilResponse(perfilRepository.save(perfil));
    }

    @Override
    public UsuarioResponse changePassword(UUID usuarioId, CambioPasswordRequest request) {
        UserEntity usuario = getUsuario(usuarioId);
        if (!passwordEncoder.matches(request.passwordActual(), usuario.getPasswordHash())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "La contraseña actual no coincide");
        }
        usuario.setPasswordHash(passwordEncoder.encode(request.passwordNueva()));
        usuario.setIntentosFallidos(0);
        usuario.setBloqueadoHasta(null);
        return mapWithPerfil(userRepository.save(usuario));
    }

    private UserEntity getUsuario(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado: " + id));
    }

    private PerfilEntity getPerfilEntity(UUID usuarioId) {
        UserEntity usuario = getUsuario(usuarioId);
        return perfilRepository.findByUsuarioId(usuario.getId()).orElseGet(() -> {
            PerfilEntity perfil = new PerfilEntity();
            perfil.setUsuario(usuario);
            perfil.setTelefono(usuario.getTelefono());
            return perfilRepository.save(perfil);
        });
    }

    private UsuarioResponse mapWithPerfil(UserEntity usuario) {
        PerfilEntity perfil = perfilRepository.findByUsuarioId(usuario.getId()).orElse(null);
        return usuarioMapper.toResponse(usuario, perfil);
    }
}