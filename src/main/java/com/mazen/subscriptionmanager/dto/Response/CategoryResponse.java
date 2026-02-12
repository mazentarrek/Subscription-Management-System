package com.mazen.subscriptionmanager.dto.Response;

public record CategoryResponse(
        Long id,
        String name,
        String icon,
        String color
) {
}
