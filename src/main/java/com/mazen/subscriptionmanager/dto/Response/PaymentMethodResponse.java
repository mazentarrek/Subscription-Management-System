package com.mazen.subscriptionmanager.dto.Response;

import com.mazen.subscriptionmanager.enums.PaymentType;

public record PaymentMethodResponse(
        Long id,
        PaymentType type,
        String lastFourDigits,
        String cardHolderName,
        boolean isDefault
) {
}
