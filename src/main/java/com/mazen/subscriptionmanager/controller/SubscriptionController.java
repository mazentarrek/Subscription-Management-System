package com.mazen.subscriptionmanager.controller;

import com.mazen.subscriptionmanager.dto.Request.SubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Response.SubscriptionResponse;
import com.mazen.subscriptionmanager.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/")
    public SubscriptionResponse createSubscription(@RequestBody SubscriptionRequest subscriptionRequest){
        return subscriptionService.createSubscription(subscriptionRequest);
    }


}
