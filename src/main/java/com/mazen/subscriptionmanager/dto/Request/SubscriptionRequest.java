package com.mazen.subscriptionmanager.dto.Request;

import com.mazen.subscriptionmanager.enums.BillingCycle;
import com.mazen.subscriptionmanager.enums.Currency;
import com.mazen.subscriptionmanager.enums.SubscriptionStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record SubscriptionRequest(
        @NotBlank String name,
        @NotBlank @Positive Double cost,
        @NotNull Currency currency,
        @NotNull BillingCycle billingCycle,
        @NotNull LocalDate startDate,
        @NotNull Long categoryId,
        Long paymentMethodId,
        String description,
        String website,
        String logoUrl,
        SubscriptionStatus status,
        boolean reminderEnabled
) { }
