package com.agrointeligente.backend.auth.controller;

import com.agrointeligente.backend.auth.dto.ChangePasswordRequest;
import com.agrointeligente.backend.auth.dto.LoginRequest;
import com.agrointeligente.backend.auth.dto.LoginResponse;
import com.agrointeligente.backend.auth.dto.RegisterRequest;
import com.agrointeligente.backend.auth.service.AuthService;
import com.agrointeligente.backend.shared.api.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticacion", description = "Endpoints para autenticacion y gestion de contrasenas")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "Autenticacion de usuario", description = "Realiza login con email y contrasena, retorna JWT token")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Login exitoso"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Email o contrasena invalida")
    })
    public ResponseEntity<ApiResponse<LoginResponse>> login(
        @Valid @RequestBody LoginRequest request,
        HttpServletRequest httpRequest) {
        var ipAddress = getClientIp(httpRequest);
        var response = authService.login(request, ipAddress);
        return ResponseEntity.ok(ApiResponse.ok("Login exitoso", response));
    }

    @PostMapping("/register")
    @Operation(summary = "Registro de nuevo usuario", description = "Registra un nuevo usuario en el sistema")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Usuario registrado exitosamente"),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Email o username ya existe")
    })
    public ResponseEntity<ApiResponse<LoginResponse>> register(
        @Valid @RequestBody RegisterRequest request) {
        var response = authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.ok("Registro exitoso", response));
    }

    @PostMapping("/refresh-token")
    @Operation(summary = "Renovar token JWT", description = "Genera un nuevo token JWT usando refresh token")
    public ResponseEntity<ApiResponse<LoginResponse>> refreshToken(
        @RequestHeader("Authorization") String authHeader) {
        var token = authHeader.replace("Bearer ", "");
        var response = authService.refreshToken(token);
        return ResponseEntity.ok(ApiResponse.ok("Token refrescado", response));
    }

    @PostMapping("/logout")
    public ResponseEntity<ApiResponse<String>> logout(
        @RequestHeader(value = "X-User-Id", required = false) Long userId) {
        if (userId != null) {
            authService.logout(userId);
        }
        return ResponseEntity.ok(ApiResponse.ok("Logout exitoso"));
    }

    @PostMapping("/forgot-password")
    public ResponseEntity<ApiResponse<String>> forgotPassword(
        @RequestBody String email) {
        authService.requestPasswordReset(email);
        return ResponseEntity.ok(ApiResponse.ok("Se envio un enlace de reset a su email"));
    }

    @PostMapping("/reset-password")
    public ResponseEntity<ApiResponse<String>> resetPassword(
        @RequestBody ResetPasswordRequest request) {
        authService.resetPassword(request.getToken(), request.getNewPassword());
        return ResponseEntity.ok(ApiResponse.ok("Contrasena reseteada exitosamente"));
    }

    @PostMapping("/change-password")
    public ResponseEntity<ApiResponse<String>> changePassword(
        @RequestHeader(value = "X-User-Id", required = false) Long userId,
        @Valid @RequestBody ChangePasswordRequest request) {
        if (userId == null) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.ok("Usuario no identificado"));
        }
        if (!request.getNewPassword().equals(request.getConfirmPassword())) {
            return ResponseEntity.badRequest()
                .body(ApiResponse.ok("Las contrasenas no coinciden"));
        }
        authService.changePassword(userId, request.getOldPassword(), request.getNewPassword());
        return ResponseEntity.ok(ApiResponse.ok("Contrasena cambiada exitosamente"));
    }

    private String getClientIp(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        if (xForwardedFor != null && !xForwardedFor.isEmpty()) {
            return xForwardedFor.split(",")[0].trim();
        }
        return request.getRemoteAddr();
    }

    public static class ResetPasswordRequest {
        public String token;
        public String newPassword;

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getNewPassword() {
            return newPassword;
        }

        public void setNewPassword(String newPassword) {
            this.newPassword = newPassword;
        }
    }
}
