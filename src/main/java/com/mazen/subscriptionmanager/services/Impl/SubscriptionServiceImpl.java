package com.mazen.subscriptionmanager.services.Impl;

import com.mazen.subscriptionmanager.dto.Request.SubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Request.UpdateSubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Response.SubscriptionResponse;
import com.mazen.subscriptionmanager.entity.Category;
import com.mazen.subscriptionmanager.entity.PaymentMethod;
import com.mazen.subscriptionmanager.entity.Subscription;
import com.mazen.subscriptionmanager.entity.User;
import com.mazen.subscriptionmanager.enums.BillingCycle;
import com.mazen.subscriptionmanager.enums.SubscriptionStatus;
import com.mazen.subscriptionmanager.mappers.SubscriptionMapper;
import com.mazen.subscriptionmanager.repositories.CategoryRepository;
import com.mazen.subscriptionmanager.repositories.PaymentMethodRepository;
import com.mazen.subscriptionmanager.repositories.SubscriptionRepository;
import com.mazen.subscriptionmanager.repositories.UserRepository;
import com.mazen.subscriptionmanager.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final CategoryRepository categoryRepository;
    private final PaymentMethodRepository paymentMethodRepository;
    private final SubscriptionMapper subscriptionMapper;
    private final UserRepository userRepository;

    public SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest, Long userId){
        if(subscriptionRepository.existsByName(subscriptionRequest.name())){
            throw new RuntimeException("Subscription already exists");
        }

        Category category = categoryRepository.findById(subscriptionRequest.categoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        PaymentMethod paymentMethod = paymentMethodRepository.findById(subscriptionRequest.paymentMethodId())
                .orElseThrow(() -> new RuntimeException("Payment Method not found"));

        User user = userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("Category not found"));

        Subscription subscription = subscriptionMapper.toEntity(subscriptionRequest);

        subscription.setCategory(category);
        subscription.setPaymentMethod(paymentMethod);
        subscription.setUser(user);

        subscription.setNextBillingDate(calculateNextBilling(subscriptionRequest.startDate(), subscriptionRequest.billingCycle()));

        Subscription savedSubscription = subscriptionRepository.save(subscription);

        return subscriptionMapper.toResponse(savedSubscription);
    }

    private LocalDate calculateNextBilling(LocalDate startDate, BillingCycle cycle) {
        if (cycle == BillingCycle.MONTHLY) {
            return startDate.plusMonths(1);
        } else if (cycle == BillingCycle.YEARLY) {
            return startDate.plusYears(1);
        }
        return startDate;
    }

    @Override
    public SubscriptionResponse updateSubscription(UpdateSubscriptionRequest updateSubscriptionRequest) {
        return null;
    }

    @Override
    public SubscriptionResponse getSubscriptionByid(Long id) {

        Subscription subscription = subscriptionRepository.findById(id).
                orElseThrow(() -> new RuntimeException("Subscription Not Found"));

        return subscriptionMapper.toResponse(subscription);
    }

    @Override
    public List<SubscriptionResponse> getAllUserSubscriptions(Long userId) {

        User user = userRepository.findById(userId).
                orElseThrow(() -> new RuntimeException("User Not Found"));

        List<Subscription> subscriptions = subscriptionRepository.findAllByUser(user);

        return subscriptions.stream()
                .map(subscriptionMapper::toResponse)
                .toList();
    }

    @Override
    public void deleteSubscription(Long id) {

        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not Found"));

        subscriptionRepository.delete(subscription);

    }

    @Override
    public SubscriptionResponse cancelSUbscription(Long id) {

        Subscription subscription = subscriptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subscription not Found"));

        subscription.setStatus(SubscriptionStatus.CANCELLED);

        Subscription savedSubscription = subscriptionRepository.save(subscription);

        return subscriptionMapper.toResponse(savedSubscription);
    }
}
