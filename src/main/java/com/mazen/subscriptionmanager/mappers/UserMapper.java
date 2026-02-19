package com.mazen.subscriptionmanager.mappers;

import com.mazen.subscriptionmanager.dto.Request.RegisterRequest;
import com.mazen.subscriptionmanager.dto.Response.AuthResponse;
import com.mazen.subscriptionmanager.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(RegisterRequest request);

    @Mapping(target = "token", source = "token")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "firstName", source = "user.firstName")
    AuthResponse toResponse(User user, String token);
}
