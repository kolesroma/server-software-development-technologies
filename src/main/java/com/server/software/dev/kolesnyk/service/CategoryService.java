package com.server.software.dev.kolesnyk.service;

import com.server.software.dev.kolesnyk.dto.CategoryDto;
import com.server.software.dev.kolesnyk.entity.CategoryEntity;
import com.server.software.dev.kolesnyk.exception.EntityNotFound;
import com.server.software.dev.kolesnyk.repository.CategoryRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void creteCategory(CategoryDto categoryDto) {
        categoryRepository.save(CategoryEntity.builder().name(categoryDto.getName()).build());
    }

    public Optional<CategoryEntity> getCategory(Integer id) {
        return categoryRepository.findById(id);
    }

    public Collection<CategoryEntity> getAllCategories(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page, size))
                .getContent();
    }

    @Transactional
    public void updateCategory(CategoryDto categoryDto, Integer id) {
        CategoryEntity category = categoryRepository.findById(id)
                .orElseThrow(EntityNotFound::new);
        category.setName(categoryDto.getName());
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteCategory(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new EntityNotFound();
        }
        categoryRepository.deleteById(id);
    }
}
