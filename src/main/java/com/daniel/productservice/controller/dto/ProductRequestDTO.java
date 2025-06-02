package com.daniel.productservice.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {
    
    @NotBlank(message = "O nome do produto é obrigatório")
    private String name;
    
    @NotBlank(message = "A descrição do produto é obrigatória")
    private String description;
    
    @NotNull(message = "O preço do produto é obrigatório")
    @Positive(message = "O preço deve ser maior que zero")
    private BigDecimal price;
    
    @NotNull(message = "O ID da categoria é obrigatório")
    private Long categoryId;
}