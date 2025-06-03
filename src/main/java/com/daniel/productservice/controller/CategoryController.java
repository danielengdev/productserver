package com.daniel.productservice.controller;

import com.daniel.productservice.model.category.CategoryRequestDTO;
import com.daniel.productservice.model.category.CategoryResponseDTO;
import com.daniel.productservice.mapper.CategoryMapper;
import com.daniel.productservice.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;
    private final CategoryMapper mapper;

    public CategoryController(CategoryService service, CategoryMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CategoryResponseDTO> getAll() {
        return service.getAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @PostMapping
    public CategoryResponseDTO create(@Valid @RequestBody CategoryRequestDTO request) {
        var category = mapper.toEntity(request);
        return mapper.toDTO(service.save(category));
    }

    @PutMapping("/{id}")
    public CategoryResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody CategoryRequestDTO request) {
        var category = mapper.toEntity(request);
        return mapper.toDTO(service.update(id, category));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}