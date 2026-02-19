package com.mazen.subscriptionmanager.controller;

import com.mazen.subscriptionmanager.dto.Request.PaymentMethodRequest;
import com.mazen.subscriptionmanager.dto.Response.PaymentMethodResponse;
import com.mazen.subscriptionmanager.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payment-method")
@RequiredArgsConstructor
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @PostMapping("/{userId}")
    public PaymentMethodResponse addPaymentMethod(@RequestBody PaymentMethodRequest paymentMethodRequest, @PathVariable Long userId){
        return paymentMethodService.addPaymentMethod(paymentMethodRequest, userId);
    }

    @GetMapping("/{userId}")
    public List<PaymentMethodResponse> getPaymentMethods(@PathVariable Long userId){
        return paymentMethodService.getUserPaymentMethods(userId);
    }

    @PatchMapping("/{paymentMethodId}/set-default")
    public PaymentMethodResponse setDefaultPaymentMethod(@PathVariable Long paymentMethodId){
        return paymentMethodService.setDefaultPaymentMethod(paymentMethodId);
    }

    @DeleteMapping("/{paymentMethodId}")
    public void deletePaymentMehod(@PathVariable Long paymentMethodId){
        paymentMethodService.deletePaymentMethod(paymentMethodId);
    }
}


