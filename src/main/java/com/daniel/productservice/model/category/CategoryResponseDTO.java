package com.daniel.productservice.model.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponseDTO {
    
    private Long id;
    private String name;
    private String description;
    private boolean active;
    private List<ProductResponseDTO> products;
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductResponseDTO {
        private Long id;
        private String name;
        private String description;
    }
}