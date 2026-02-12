package com.mazen.subscriptionmanager.dto.Response;

import com.mazen.subscriptionmanager.entity.Category;
import com.mazen.subscriptionmanager.entity.PaymentMethod;
import com.mazen.subscriptionmanager.enums.BillingCycle;

import java.time.LocalDate;

public record SubscriptionResponse(
        Long id,
        String name,
        Double cost,
        String currency,
        BillingCycle billingCycle,
        LocalDate nextBillingDate,
        String status,
        CategoryResponse category,
        PaymentMethodResponse paymentMethod,
        String logoUrl
) {
}
