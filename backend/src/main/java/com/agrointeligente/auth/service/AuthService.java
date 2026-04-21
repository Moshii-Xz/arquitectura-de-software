package com.agrointeligente.auth.service;

import com.agrointeligente.auth.dto.AuthResponse;
import com.agrointeligente.auth.dto.LoginRequest;
import com.agrointeligente.auth.dto.RegistroRequest;

public interface AuthService {

    AuthResponse register(RegistroRequest request);

    AuthResponse login(LoginRequest request);
}