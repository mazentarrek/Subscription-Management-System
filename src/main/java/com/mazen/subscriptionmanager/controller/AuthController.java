package com.mazen.subscriptionmanager.controller;

import com.mazen.subscriptionmanager.dto.Request.LoginRequest;
import com.mazen.subscriptionmanager.dto.Request.RegisterRequest;
import com.mazen.subscriptionmanager.dto.Request.ResetPasswordRequest;
import com.mazen.subscriptionmanager.dto.Response.AuthResponse;
import com.mazen.subscriptionmanager.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public AuthResponse register(@RequestBody RegisterRequest registerRequest){
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest loginRequest){
        return authService.login(loginRequest);
    }
    
    @PostMapping("/reset-password")
    public AuthResponse reset_password(@RequestBody ResetPasswordRequest resetPasswordRequest){
        return authService.reset_password(resetPasswordRequest);
    }
}
