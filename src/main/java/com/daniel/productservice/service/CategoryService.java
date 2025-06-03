package com.daniel.productservice.service;

import com.daniel.productservice.model.category.Category;
import com.daniel.productservice.exceptions.RecursoNaoEncontradoException;
import com.daniel.productservice.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> getAll() {
        return repository.findByActiveTrue();
    }

    public Category getById(Long id) {
        return repository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Categoria não encontrada com id: " + id));
    }

    public Category save(Category category) {
        return repository.save(category);
    }

    public Category update(Long id, Category category) {
        Category existingCategory = getById(id);
        existingCategory.setName(category.getName());
        existingCategory.setDescription(category.getDescription());

        return repository.save(existingCategory);
    }

    public void delete(Long id) {
        Category existingCategory = getById(id);
        existingCategory.setActive(false);
        repository.save(existingCategory);
    }
}