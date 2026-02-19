package com.mazen.subscriptionmanager.services;

import com.mazen.subscriptionmanager.dto.Request.LoginRequest;
import com.mazen.subscriptionmanager.dto.Request.RegisterRequest;
import com.mazen.subscriptionmanager.dto.Request.ResetPasswordRequest;
import com.mazen.subscriptionmanager.dto.Response.AuthResponse;

public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);
    AuthResponse login(LoginRequest loginRequest);
    AuthResponse reset_password(ResetPasswordRequest resetPasswordRequest);
}
