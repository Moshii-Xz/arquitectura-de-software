package com.agrointeligente.backend.auth.service;

import com.agrointeligente.backend.auth.dto.LoginRequest;
import com.agrointeligente.backend.auth.dto.LoginResponse;
import com.agrointeligente.backend.auth.dto.RegisterRequest;
import com.agrointeligente.backend.auth.entity.User;

public interface AuthService {

    LoginResponse login(LoginRequest request, String ipAddress);

    LoginResponse register(RegisterRequest request);

    LoginResponse refreshToken(String refreshToken);

    void logout(Long userId);

    void validateToken(String token);

    User getCurrentUser();

    void requestPasswordReset(String email);

    void resetPassword(String token, String newPassword);

    void changePassword(Long userId, String oldPassword, String newPassword);
}
