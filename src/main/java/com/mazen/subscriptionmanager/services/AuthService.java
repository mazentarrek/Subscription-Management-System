package com.mazen.subscriptionmanager.services;

import com.mazen.subscriptionmanager.dto.Request.LoginRequest;
import com.mazen.subscriptionmanager.dto.Request.RegisterRequest;
import com.mazen.subscriptionmanager.dto.Response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse refreshtoken(String refreshToken);
    void logout(String token);
}
