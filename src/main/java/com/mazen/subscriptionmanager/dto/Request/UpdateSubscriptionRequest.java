package com.mazen.subscriptionmanager.dto.Request;

import com.mazen.subscriptionmanager.enums.BillingCycle;
import com.mazen.subscriptionmanager.enums.SubscriptionStatus;

//partial updates allowed
public record UpdateSubscriptionRequest(
        String name,
        Double cost,
        BillingCycle billingCycle,
        SubscriptionStatus status,
        Long categoryId,
        String description,
        boolean reminderEnabled
) {
}
