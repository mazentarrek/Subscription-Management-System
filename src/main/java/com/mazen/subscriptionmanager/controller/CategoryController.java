package com.mazen.subscriptionmanager.controller;

import com.mazen.subscriptionmanager.dto.Request.CategoryRequest;
import com.mazen.subscriptionmanager.dto.Response.CategoryResponse;
import com.mazen.subscriptionmanager.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/")
    public CategoryResponse createCategory(@RequestBody CategoryRequest createCategoryRequest){
        return categoryService.createCategory(createCategoryRequest);
    }

    @GetMapping("/")
    public List<CategoryResponse> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping("/{id}")
    public CategoryResponse getCategoryById(@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }
}
