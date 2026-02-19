package com.mazen.subscriptionmanager.dto.Response;

import java.time.LocalDateTime;

public record ErrorResponse(
        LocalDateTime timestamp,
        String error,
        String message
) {
}
