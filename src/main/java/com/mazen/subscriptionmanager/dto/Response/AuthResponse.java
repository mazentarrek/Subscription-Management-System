package com.mazen.subscriptionmanager.dto.Response;

public record AuthResponse(
        String token,
        String refreshToken,
        Long userId,
        String email,
        String firstName
) {
}
