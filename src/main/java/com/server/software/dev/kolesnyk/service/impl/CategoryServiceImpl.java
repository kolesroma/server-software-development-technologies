package com.server.software.dev.kolesnyk.service.impl;

import com.server.software.dev.kolesnyk.dto.CategoryDto;
import com.server.software.dev.kolesnyk.entity.CategoryEntity;
import com.server.software.dev.kolesnyk.exception.CategoryNotFound;
import com.server.software.dev.kolesnyk.repository.CategoryRepository;
import com.server.software.dev.kolesnyk.service.CategoryService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void creteCategory(CategoryDto categoryDto) {
        categoryRepository.save(CategoryEntity.builder().name(categoryDto.getName()).build());
    }

    @Override
    public Optional<CategoryEntity> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Collection<CategoryEntity> getAllCategories(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Override
    @Transactional
    public void updateCategory(CategoryDto categoryDto, Integer id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFound::new);
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
    }

    @Override
    @Transactional
    public void deleteCategory(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFound();
        }
        categoryRepository.deleteById(id);
    }
}
