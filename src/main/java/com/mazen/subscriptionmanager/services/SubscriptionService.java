package com.mazen.subscriptionmanager.services;

import com.mazen.subscriptionmanager.dto.Request.SubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Request.UpdateSubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Response.SubscriptionResponse;
import com.mazen.subscriptionmanager.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    SubscriptionResponse createSubscription(SubscriptionRequest subscriptionRequest);
    SubscriptionResponse updateSubscription(UpdateSubscriptionRequest updateSubscriptionRequest);
    SubscriptionResponse getSubscriptionByid(Long id);
    List<Subscription> getAllUserSubscriptions(Long userId);
    void deleteSubscription(Long id);
    void cancelSUbscription(Long id);
}
