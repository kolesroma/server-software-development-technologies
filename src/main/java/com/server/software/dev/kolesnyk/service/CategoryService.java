package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.CategoryDto;
import com.server.software.dev.kolesnyk.entity.CategoryEntity;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {
    void creteCategory(CategoryDto categoryDto);

    Optional<CategoryEntity> getCategory(Integer id);

    Collection<CategoryEntity> getAllCategories(Integer page, Integer size);

    void updateCategory(CategoryDto categoryDto, Integer id);

    void deleteCategory(Integer id);
}
