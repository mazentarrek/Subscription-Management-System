package com.mazen.subscriptionmanager.services.Impl;

import com.mazen.subscriptionmanager.dto.Request.CategoryRequest;
import com.mazen.subscriptionmanager.dto.Response.CategoryResponse;
import com.mazen.subscriptionmanager.entity.Category;
import com.mazen.subscriptionmanager.mappers.CategoryMapper;
import com.mazen.subscriptionmanager.repositories.CategoryRepository;
import com.mazen.subscriptionmanager.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest request) {

        if (categoryRepository.existsByName(request.name())){
            throw new RuntimeException("Category already exists");
        }

        Category category = categoryMapper.toEntity(request);

        Category savedCategory = categoryRepository.save(category);

        return categoryMapper.toResponse(savedCategory);
    }

    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toResponse)
                .toList();
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category does not exist"));

        return categoryMapper.toResponse(category);
    }
}
