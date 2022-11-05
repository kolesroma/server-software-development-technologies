package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.entity.CategoryEntity;
import com.server.software.dev.kolesnyk.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Optional<CategoryEntity> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

}
