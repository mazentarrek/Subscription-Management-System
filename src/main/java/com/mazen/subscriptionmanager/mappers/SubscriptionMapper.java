package com.mazen.subscriptionmanager.mappers;

import com.mazen.subscriptionmanager.dto.Request.SubscriptionRequest;
import com.mazen.subscriptionmanager.dto.Response.SubscriptionResponse;
import com.mazen.subscriptionmanager.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubscriptionMapper {

    //Map Entity -> Response DTO
    SubscriptionResponse toResponse(Subscription subscription);

    //Map Request DTO -> Entity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Subscription toEntity(SubscriptionRequest request);
}
