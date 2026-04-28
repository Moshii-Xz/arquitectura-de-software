package com.agrointeligente.backend.auth.service.impl;

import com.agrointeligente.backend.auth.dto.LoginRequest;
import com.agrointeligente.backend.auth.dto.LoginResponse;
import com.agrointeligente.backend.auth.dto.RegisterRequest;
import com.agrointeligente.backend.auth.dto.UserDto;
import com.agrointeligente.backend.auth.entity.LoginAttempt;
import com.agrointeligente.backend.auth.entity.PasswordReset;
import com.agrointeligente.backend.auth.entity.Role;
import com.agrointeligente.backend.auth.entity.User;
import com.agrointeligente.backend.auth.mapper.UserMapper;
import com.agrointeligente.backend.auth.repository.LoginAttemptRepository;
import com.agrointeligente.backend.auth.repository.PasswordResetRepository;
import com.agrointeligente.backend.auth.repository.RoleRepository;
import com.agrointeligente.backend.auth.repository.UserRepository;
import com.agrointeligente.backend.auth.service.AuthService;
import com.agrointeligente.backend.auth.util.JwtProvider;
import com.agrointeligente.backend.shared.exception.BusinessException;
import com.agrointeligente.backend.user.entity.NotificationPreference;
import com.agrointeligente.backend.user.entity.UserProfile;
import com.agrointeligente.backend.user.repository.NotificationPreferenceRepository;
import com.agrointeligente.backend.user.repository.UserProfileRepository;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final LoginAttemptRepository loginAttemptRepository;
    private final PasswordResetRepository passwordResetRepository;
    private final UserProfileRepository userProfileRepository;
    private final NotificationPreferenceRepository notificationPreferenceRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final UserMapper userMapper;

    @Value("${app.jwt.expiration}")
    private long jwtExpiration;

    @Value("${app.jwt.refresh-expiration:604800000}")
    private long jwtRefreshExpiration;

    @Value("${app.max-login-attempts:5}")
    private int maxLoginAttempts;

    @Value("${app.lock-timeout-minutes:15}")
    private int lockTimeoutMinutes;

    @Override
    public LoginResponse login(LoginRequest request, String ipAddress) {
        var user = userRepository.findByEmail(request.getEmail())
            .orElseThrow(() -> new BusinessException("Email o contrasena invalida"));

        // Check if user is locked
        var recentFailures = loginAttemptRepository.findByEmailAndAttemptedAtAfter(
            request.getEmail(),
            LocalDateTime.now().minusMinutes(lockTimeoutMinutes)
        );
        if (recentFailures.size() >= maxLoginAttempts) {
            throw new BusinessException("Cuenta bloqueada debido a multiples intentos fallidos. Intente despues de "
                + lockTimeoutMinutes + " minutos");
        }

        if (!passwordEncoder.matches(request.getPassword(), user.getPasswordHash())) {
            loginAttemptRepository.save(LoginAttempt.builder()
                .email(request.getEmail())
                .ipAddress(ipAddress)
                .success(false)
                .attemptedAt(LocalDateTime.now())
                .build());
            throw new BusinessException("Email o contrasena invalida");
        }

        if (!"ACTIVE".equals(user.getStatus())) {
            throw new BusinessException("Cuenta no esta activa");
        }

        // Record successful login
        loginAttemptRepository.save(LoginAttempt.builder()
            .user(user)
            .email(request.getEmail())
            .ipAddress(ipAddress)
            .success(true)
            .attemptedAt(LocalDateTime.now())
            .build());

        user.setLastLoginAt(LocalDateTime.now());
        user.setLoginAttempts(0);
        userRepository.save(user);

        var token = jwtProvider.generateToken(user);
        var refreshToken = jwtProvider.generateRefreshToken(user);
        var userDto = userMapper.toDto(user);

        return LoginResponse.builder()
            .token(token)
            .refreshToken(refreshToken)
            .user(userDto)
            .expiresIn(jwtExpiration / 1000)
            .build();
    }

    @Override
    public LoginResponse register(RegisterRequest request) {
        if (!request.getPassword().equals(request.getPasswordConfirm())) {
            throw new BusinessException("Las contrasenas no coinciden");
        }

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException("Email ya existe");
        }

        if (userRepository.existsByUsername(request.getUsername())) {
            throw new BusinessException("Username ya existe");
        }

        var role = roleRepository.findByName("ROLE_USER")
            .orElseThrow(() -> new BusinessException("Rol por defecto no encontrado"));

        var user = User.builder()
            .username(request.getUsername())
            .email(request.getEmail())
            .passwordHash(passwordEncoder.encode(request.getPassword()))
            .role(role)
            .status("ACTIVE")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .loginAttempts(0)
            .build();

        userRepository.save(user);

        // Create default profile
        userProfileRepository.save(UserProfile.builder()
            .user(user)
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .language("es")
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build());

        // Create default notification preferences
        notificationPreferenceRepository.save(NotificationPreference.builder()
            .user(user)
            .emailNotifications(true)
            .pushNotifications(true)
            .smsNotifications(false)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .build());

        log.info("Nuevo usuario registrado: {}", user.getEmail());

        return LoginResponse.builder()
            .user(userMapper.toDto(user))
            .build();
    }

    @Override
    public LoginResponse refreshToken(String refreshToken) {
        if (!jwtProvider.validateToken(refreshToken)) {
            throw new BusinessException("Token invalido o expirado");
        }

        var email = jwtProvider.getEmailFromToken(refreshToken);
        var user = userRepository.findByEmail(email)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        var token = jwtProvider.generateToken(user);
        var userDto = userMapper.toDto(user);

        return LoginResponse.builder()
            .token(token)
            .refreshToken(refreshToken)
            .user(userDto)
            .expiresIn(jwtExpiration / 1000)
            .build();
    }

    @Override
    public void logout(Long userId) {
        log.info("Usuario logout: {}", userId);
    }

    @Override
    public void validateToken(String token) {
        if (!jwtProvider.validateToken(token)) {
            throw new BusinessException("Token invalido o expirado");
        }
    }

    @Override
    public User getCurrentUser() {
        // TODO: Implementar con SecurityContext
        return null;
    }

    @Override
    public void requestPasswordReset(String email) {
        var user = userRepository.findByEmail(email)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        var resetToken = UUID.randomUUID().toString();
        var passwordReset = PasswordReset.builder()
            .user(user)
            .resetToken(resetToken)
            .expiresAt(LocalDateTime.now().plusHours(1))
            .createdAt(LocalDateTime.now())
            .build();

        passwordResetRepository.save(passwordReset);
        log.info("Password reset solicitado para: {}", email);
    }

    @Override
    public void resetPassword(String token, String newPassword) {
        var passwordReset = passwordResetRepository.findByResetToken(token)
            .orElseThrow(() -> new BusinessException("Token de reset invalido"));

        if (passwordReset.getExpiresAt().isBefore(LocalDateTime.now())) {
            throw new BusinessException("Token de reset expirado");
        }

        var user = passwordReset.getUser();
        user.setPasswordHash(passwordEncoder.encode(newPassword));
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        passwordReset.setUsedAt(LocalDateTime.now());
        passwordResetRepository.save(passwordReset);

        log.info("Password reset completado para: {}", user.getEmail());
    }

    @Override
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        var user = userRepository.findById(userId)
            .orElseThrow(() -> new BusinessException("Usuario no encontrado"));

        if (!passwordEncoder.matches(oldPassword, user.getPasswordHash())) {
            throw new BusinessException("Contrasena actual es incorrecta");
        }

        user.setPasswordHash(passwordEncoder.encode(newPassword));
        user.setUpdatedAt(LocalDateTime.now());
        userRepository.save(user);

        log.info("Password cambiado para usuario: {}", userId);
    }
}
