package com.daniel.productservice.mapper;
import com.daniel.productservice.model.product.ProductRequestDTO;
import com.daniel.productservice.model.product.ProductResponseDTO;
import com.daniel.productservice.model.product.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product toEntity(ProductRequestDTO dto) {
        return Product.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .price(dto.getPrice())
                .active(true)
                .build();
    }

    public ProductResponseDTO toDTO(Product product) {
        return ProductResponseDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .active(product.isActive())
                .category(product.getCategory() != null ? 
                    ProductResponseDTO.CategoryResponseDTO.builder()
                        .id(product.getCategory().getId())
                        .name(product.getCategory().getName())
                        .build() : null)
                .build();
    }
}