package com.mazen.subscriptionmanager.mappers;

import com.mazen.subscriptionmanager.dto.Request.PaymentMethodRequest;
import com.mazen.subscriptionmanager.dto.Response.PaymentMethodResponse;
import com.mazen.subscriptionmanager.entity.PaymentMethod;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {

    PaymentMethod toEntity(PaymentMethodRequest request);

    PaymentMethodResponse toResponse(PaymentMethod savedPaymentMethod);
}
