package com.mazen.subscriptionmanager.controller;

import com.mazen.subscriptionmanager.dto.Request.SubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Response.SubscriptionResponse;
import com.mazen.subscriptionmanager.services.SubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subscription")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    @PostMapping("/{userId}")
    public SubscriptionResponse createSubscription(@RequestBody SubscriptionRequest subscriptionRequest, @PathVariable Long userId){
        return subscriptionService.createSubscription(subscriptionRequest, userId);
    }

    @GetMapping("/getSubscription/{subscriptionId}")
    public SubscriptionResponse getSubscriptionById(@PathVariable Long subscriptionId){
        return subscriptionService.getSubscriptionByid(subscriptionId);
    }

    @GetMapping("/getUserSubscriptions/{userId}")
    public List<SubscriptionResponse> getAllUserSubscriptions(@PathVariable Long userId){
        return subscriptionService.getAllUserSubscriptions(userId);
    }

    @DeleteMapping("/subscriptionId")
    public void deleteSubscription(@PathVariable Long subScriptionId){
        subscriptionService.deleteSubscription(subScriptionId);
    }

    @PatchMapping("/cancelSubscription/{subscriptionId}")
    public SubscriptionResponse cancelSubscription(@PathVariable Long subscriptionId){
        return subscriptionService.cancelSUbscription(subscriptionId);
    }


}
