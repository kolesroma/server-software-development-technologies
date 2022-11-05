package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.CategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<CategoryEntity, Integer> {
}
