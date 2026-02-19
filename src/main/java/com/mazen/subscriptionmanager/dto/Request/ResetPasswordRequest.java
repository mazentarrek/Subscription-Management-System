package com.mazen.subscriptionmanager.dto.Request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ResetPasswordRequest(
        @NotBlank @Email String email,
        @NotBlank String old_password,
        @NotBlank String new_password
) {
}
