package com.server.software.dev.kolesnyk.controller;

import com.server.software.dev.kolesnyk.entity.Category;
import com.server.software.dev.kolesnyk.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/home/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable int categoryId) {
        return categoryRepository.getById(categoryId);
    }

    @GetMapping
    public Collection<Category> getAllCategories() {
        return categoryRepository.getAll();
    }

    @PostMapping
    public void createCategory(@RequestBody Category category) {
        categoryRepository.create(category);
    }

    @PutMapping("/{categoryId}")
    public void updateCategory(@RequestBody Category category, @PathVariable int categoryId) {
        categoryRepository.update(category, categoryId);
    }

    @DeleteMapping("{categoryId}")
    public void deleteCategory(@PathVariable int categoryId) {
        categoryRepository.delete(categoryId);
    }
}
