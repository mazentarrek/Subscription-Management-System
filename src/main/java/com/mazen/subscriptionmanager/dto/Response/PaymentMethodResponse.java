package com.mazen.subscriptionmanager.dto.Response;

import com.mazen.subscriptionmanager.enums.PaymentType;

public record PaymentMethodResponse(
        Long id,
        PaymentType type,
        String lastFourDigits, // "************4444"
        String cardHolderName,
        boolean isDefault
) {
}
