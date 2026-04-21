package com.agrointeligente.auth.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import com.agrointeligente.auth.dto.AuthResponse;
import com.agrointeligente.auth.dto.LoginRequest;
import com.agrointeligente.auth.dto.RegistroRequest;
import com.agrointeligente.entity.UserEntity;
import com.agrointeligente.repository.UserRepository;
import com.agrointeligente.usuario.dto.UsuarioResponse;
import com.agrointeligente.usuario.entity.PerfilEntity;
import com.agrointeligente.usuario.repository.PerfilRepository;
import com.agrointeligente.usuario.service.UsuarioMapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class AuthServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PerfilRepository perfilRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenService jwtTokenService;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private AuthServiceImpl authService;

    @Test
    void registerCreatesUserAndReturnsToken() {
        RegistroRequest request = new RegistroRequest("123", "Ana", "Pérez", "3001234567", "Ciénaga",
                "Cordobita", "ana@example.com", "Password123");

        UserEntity saved = new UserEntity();
        saved.setId(UUID.randomUUID());
        saved.setDocumento(request.documento());
        saved.setNombres(request.nombres());
        saved.setApellidos(request.apellidos());
        saved.setTelefono(request.telefono());
        saved.setEmail(request.email());
        saved.setPasswordHash("hashed");
        saved.setRol("PRODUCTOR");

        when(userRepository.existsByDocumento(request.documento())).thenReturn(false);
        when(passwordEncoder.encode(request.password())).thenReturn("hashed");
        when(userRepository.save(any(UserEntity.class))).thenReturn(saved);
        when(jwtTokenService.generateToken(saved)).thenReturn(new JwtTokenService.TokenData("token", Instant.now()));
        when(usuarioMapper.toResponse(saved)).thenReturn(new UsuarioResponse(saved.getId(), saved.getDocumento(),
                saved.getNombres(), saved.getApellidos(), saved.getTelefono(), saved.getEmail(), saved.getRol(), true,
                null, null, null, null));

        AuthResponse response = authService.register(request);

        assertThat(response.accessToken()).isEqualTo("token");
        verify(userRepository).save(any(UserEntity.class));
        verify(perfilRepository).save(any(PerfilEntity.class));
    }

    @Test
    void loginReturnsTokenForValidCredentials() {
        LoginRequest request = new LoginRequest("123", "Password123");
        UserEntity user = new UserEntity();
        user.setId(UUID.randomUUID());
        user.setDocumento("123");
        user.setNombres("Ana");
        user.setTelefono("3001234567");
        user.setPasswordHash("hashed");
        user.setActivo(true);
        user.setRol("PRODUCTOR");

        when(userRepository.findByDocumento("123")).thenReturn(Optional.of(user));
        when(passwordEncoder.matches(request.password(), user.getPasswordHash())).thenReturn(true);
        when(userRepository.save(user)).thenReturn(user);
        when(jwtTokenService.generateToken(user)).thenReturn(new JwtTokenService.TokenData("token", Instant.now()));
        when(usuarioMapper.toResponse(user)).thenReturn(new UsuarioResponse(user.getId(), user.getDocumento(),
                user.getNombres(), null, user.getTelefono(), null, user.getRol(), true, null, null, null, null));

        AuthResponse response = authService.login(request);

        assertThat(response.accessToken()).isEqualTo("token");
        verify(userRepository).save(user);
    }
}