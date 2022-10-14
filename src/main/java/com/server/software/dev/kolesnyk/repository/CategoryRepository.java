package com.server.software.dev.kolesnyk.repository;

import com.server.software.dev.kolesnyk.entity.Category;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CategoryRepository {
    private final Map<Integer, Category> categories = new HashMap<>();

    public void create(Category category) {
        categories.put(category.getId(), category);
    }

    public Category getById(int id) {
        return categories.get(id);
    }

    public Collection<Category> getAll() {
        return categories.values();
    }

    public void update(Category category, int id) {
        categories.put(id, category);
    }

    public void delete(int id) {
        categories.remove(id);
    }
}
