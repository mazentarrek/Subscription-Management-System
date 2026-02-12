package com.mazen.subscriptionmanager.mappers;

import com.mazen.subscriptionmanager.dto.Request.CategoryRequest;
import com.mazen.subscriptionmanager.dto.Response.CategoryResponse;
import com.mazen.subscriptionmanager.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toResponse(Category entity);

    @Mapping(target = "id", ignore = true)
    Category toEntity(CategoryRequest request);
}
