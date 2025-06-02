package com.daniel.productservice.repository;

import com.daniel.productservice.model.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findByActiveTrue();
    Optional<Category> findByIdAndActiveTrue(Long id);

}
