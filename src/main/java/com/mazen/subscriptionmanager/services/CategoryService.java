package com.mazen.subscriptionmanager.services;

import com.mazen.subscriptionmanager.dto.Request.CategoryRequest;
import com.mazen.subscriptionmanager.dto.Response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    CategoryResponse createCategory(CategoryRequest request);
    List<CategoryResponse> getAllCategories();
    CategoryResponse getCategoryById(Long id);
}
