package com.agrointeligente.auth.service;

import java.time.LocalDateTime;

import com.agrointeligente.auth.dto.AuthResponse;
import com.agrointeligente.auth.dto.LoginRequest;
import com.agrointeligente.auth.dto.RegistroRequest;
import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.exception.NotFoundException;
import com.agrointeligente.repository.UserRepository;
import com.agrointeligente.usuario.entity.PerfilEntity;
import com.agrointeligente.usuario.repository.PerfilRepository;
import com.agrointeligente.usuario.service.UsuarioMapper;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PerfilRepository perfilRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenService jwtTokenService;
    private final UsuarioMapper usuarioMapper;

    public AuthServiceImpl(UserRepository userRepository, PerfilRepository perfilRepository,
            PasswordEncoder passwordEncoder, JwtTokenService jwtTokenService, UsuarioMapper usuarioMapper) {
        this.userRepository = userRepository;
        this.perfilRepository = perfilRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenService = jwtTokenService;
        this.usuarioMapper = usuarioMapper;
    }

    @Override
    public AuthResponse register(RegistroRequest request) {
        if (userRepository.existsByDocumento(request.documento())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Ya existe un usuario con ese documento");
        }

        UserEntity usuario = new UserEntity();
        usuario.setDocumento(request.documento());
        usuario.setNombres(request.nombres());
        usuario.setApellidos(request.apellidos());
        usuario.setTelefono(request.telefono());
        usuario.setEmail(request.email());
        usuario.setPasswordHash(passwordEncoder.encode(request.password()));
        usuario.setRol("PRODUCTOR");
        usuario.setActivo(true);
        usuario.setIntentosFallidos(0);
        usuario.setBloqueadoHasta(null);
        usuario = userRepository.save(usuario);

        PerfilEntity perfil = new PerfilEntity();
        perfil.setUsuario(usuario);
        perfil.setMunicipio(request.municipio());
        perfil.setVereda(request.vereda());
        perfil.setTelefono(request.telefono());
        perfilRepository.save(perfil);

        JwtTokenService.TokenData tokenData = jwtTokenService.generateToken(usuario);
        return new AuthResponse(tokenData.token(), "Bearer", tokenData.expiresAt(), usuarioMapper.toResponse(usuario));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        UserEntity usuario = userRepository.findByDocumento(request.identificador())
                .or(() -> userRepository.findByTelefono(request.identificador()))
                .or(() -> userRepository.findByEmail(request.identificador()))
                .orElseThrow(() -> new NotFoundException("Usuario no encontrado"));

        if (!usuario.isActivo()) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "La cuenta está desactivada");
        }
        if (usuario.getBloqueadoHasta() != null && usuario.getBloqueadoHasta().isAfter(LocalDateTime.now())) {
            throw new ResponseStatusException(HttpStatus.LOCKED, "La cuenta está bloqueada temporalmente");
        }
        if (!passwordEncoder.matches(request.password(), usuario.getPasswordHash())) {
            int intentos = usuario.getIntentosFallidos() + 1;
            usuario.setIntentosFallidos(intentos);
            if (intentos >= 3) {
                usuario.setBloqueadoHasta(LocalDateTime.now().plusMinutes(15));
                usuario.setIntentosFallidos(0);
            }
            userRepository.save(usuario);
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }

        usuario.setIntentosFallidos(0);
        usuario.setBloqueadoHasta(null);
        usuario.setUltimoAcceso(LocalDateTime.now());
        usuario = userRepository.save(usuario);

        JwtTokenService.TokenData tokenData = jwtTokenService.generateToken(usuario);
        return new AuthResponse(tokenData.token(), "Bearer", tokenData.expiresAt(), usuarioMapper.toResponse(usuario));
    }
}