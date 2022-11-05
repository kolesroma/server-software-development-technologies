package com.server.software.dev.kolesnyk.controller;

import com.server.software.dev.kolesnyk.dto.CategoryDto;
import com.server.software.dev.kolesnyk.entity.CategoryEntity;
import com.server.software.dev.kolesnyk.service.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public void createCategory(@RequestBody @Valid CategoryDto categoryDto) {
        categoryService.creteCategory(categoryDto);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryEntity> getCategory(@PathVariable Integer categoryId) {
        return ResponseEntity.of(categoryService.getCategory(categoryId));
    }

    @GetMapping
    public Collection<CategoryEntity> getAllCategories(@RequestParam Integer page, @RequestParam Integer size) {
        return categoryService.getAllCategories(page, size);
    }

    @PatchMapping("/{categoryId}")
    public void updateCategory(@RequestBody @Valid CategoryDto categoryDto, @PathVariable Integer categoryId) {
        categoryService.updateCategory(categoryDto, categoryId);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
