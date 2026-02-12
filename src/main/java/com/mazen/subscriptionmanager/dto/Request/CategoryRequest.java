package com.mazen.subscriptionmanager.dto.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CategoryRequest(
        @NotBlank String name,
        String description,
        String icon,
        @Size(min = 7, max = 7) String color
) {
}
