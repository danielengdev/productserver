package com.daniel.productservice.repository;
import com.daniel.productservice.model.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByActiveTrue();
    Optional<Product> findByIdAndActiveTrue(Long id);

}