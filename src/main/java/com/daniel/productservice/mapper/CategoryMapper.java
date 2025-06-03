package com.daniel.productservice.mapper;

import com.daniel.productservice.model.category.Category;
import com.daniel.productservice.model.category.CategoryRequestDTO;
import com.daniel.productservice.model.category.CategoryResponseDTO;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CategoryMapper {

    public Category toEntity(CategoryRequestDTO dto) {
        return Category.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .active(true)
                .build();
    }

    public CategoryResponseDTO toDTO(Category category) {
        var responseDTO = CategoryResponseDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .active(category.isActive())
                .build();

        if (category.getProducts() != null && !category.getProducts().isEmpty()) {
            responseDTO.setProducts(
                category.getProducts().stream()
                    .map(product -> CategoryResponseDTO.ProductResponseDTO.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .build())
                    .collect(Collectors.toList())
            );
        }

        return responseDTO;
    }
}