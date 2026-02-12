package com.mazen.subscriptionmanager.dto.Request;

import com.mazen.subscriptionmanager.enums.PaymentType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PaymentMethodRequest(
        @NotNull PaymentType type,
        @NotBlank @Size(min = 4, max = 4) String lastFourDigits,
        @NotBlank String cardHolderName,
        @NotNull LocalDate expiryDate,
        boolean isDefault
) {
}
