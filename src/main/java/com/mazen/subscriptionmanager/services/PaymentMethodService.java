package com.mazen.subscriptionmanager.services;

import com.mazen.subscriptionmanager.dto.Request.PaymentMethodRequest;
import com.mazen.subscriptionmanager.dto.Response.PaymentMethodResponse;

import java.util.List;

public interface PaymentMethodService {
    PaymentMethodResponse addPaymentMethod(PaymentMethodRequest request, Long userId);
    List<PaymentMethodResponse> getUserPaymentMethods(Long userId);
    PaymentMethodResponse setDefaultPaymentMethod(Long id);
    void deletePaymentMethod(Long id);
}