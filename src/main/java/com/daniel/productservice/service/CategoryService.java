package com.daniel.productservice.service;

import com.daniel.productservice.entity.Category;
import com.daniel.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> getAll() {
        return repository.findAll();
    }

    public Optional<Category> getById(Long id) {
        return repository.findById(id);
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Category update(Long id, Category category) {
        category.setId(id);
        return repository.save(category);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
