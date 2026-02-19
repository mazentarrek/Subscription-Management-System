package com.mazen.subscriptionmanager.services.Impl;

import com.mazen.subscriptionmanager.dto.Request.PaymentMethodRequest;
import com.mazen.subscriptionmanager.dto.Response.PaymentMethodResponse;
import com.mazen.subscriptionmanager.entity.PaymentMethod;
import com.mazen.subscriptionmanager.entity.User;
import com.mazen.subscriptionmanager.mappers.PaymentMethodMapper;
import com.mazen.subscriptionmanager.repositories.PaymentMethodRepository;
import com.mazen.subscriptionmanager.repositories.UserRepository;
import com.mazen.subscriptionmanager.services.PaymentMethodService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentMethodImpl implements PaymentMethodService {

    private final PaymentMethodRepository paymentMethodRepository;
    private final PaymentMethodMapper paymentMethodMapper;
    private final UserRepository userRepository;

    @Override
    public PaymentMethodResponse addPaymentMethod(PaymentMethodRequest request, Long userId) {
        // 1. Check for duplicates specific to THIS user
        if (paymentMethodRepository.existsByLastFourDigitsAndTypeAndUserId(
                request.lastFourDigits(), request.type(), userId)) {
            throw new RuntimeException("You have already added this payment method");
        }

        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(request);

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        paymentMethod.setUser(user);
        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);

        return paymentMethodMapper.toResponse(savedPaymentMethod);
    }

    @Override
    public List<PaymentMethodResponse> getUserPaymentMethods(Long userId) {
        return paymentMethodRepository.findAll()
                .stream()
                .map(paymentMethodMapper::toResponse)
                .toList();
    }

    @Override
    @Transactional
    public PaymentMethodResponse setDefaultPaymentMethod(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment Method does not exist"));

        paymentMethodRepository.resetDefaultByUserId(paymentMethod.getUser().getId());

        paymentMethod.setDefault(true);

        PaymentMethod saved = paymentMethodRepository.save(paymentMethod);
        return paymentMethodMapper.toResponse(saved);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Payment Method does not exist"));

        paymentMethodRepository.delete(paymentMethod);
    }
}
