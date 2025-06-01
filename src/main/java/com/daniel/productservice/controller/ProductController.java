package com.daniel.productservice.controller;

import com.daniel.productservice.model.product.ProductRequestDTO;
import com.daniel.productservice.model.product.ProductResponseDTO;
import com.daniel.productservice.mapper.ProductMapper;
import com.daniel.productservice.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;
    private final ProductMapper mapper;

    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<ProductResponseDTO> getAll() {
        return service.getAll().stream()
                .map(mapper::toDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDTO(service.getById(id)));
    }

    @PostMapping
    public ProductResponseDTO create(@Valid @RequestBody ProductRequestDTO request) {
        var product = mapper.toEntity(request);
        return mapper.toDTO(service.save(product));
    }

    @PutMapping("/{id}")
    public ProductResponseDTO update(
            @PathVariable Long id,
            @Valid @RequestBody ProductRequestDTO request) {
        var product = mapper.toEntity(request);
        return mapper.toDTO(service.update(id, product));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}