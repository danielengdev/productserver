package com.daniel.productservice.service;

import com.daniel.productservice.entity.Product;
import com.daniel.productservice.exceptions.RecursoNaoEncontradoException;
import com.daniel.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAll() {
        return repository.findByActiveTrue();
    }

    public Product getById(Long id) {
        return repository.findByIdAndActiveTrue(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado com id: " + id));
    }

    public Product save(Product product) {
        return repository.save(product);
    }

    public Product update(Long id, Product product) {
        Product existingProduct = getById(id);

        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        existingProduct.setPrice(product.getPrice());

        return repository.save(existingProduct);
    }

    public void delete(Long id) {
        Product existingProduct = getById(id);
        existingProduct.setActive(false);
        repository.save(existingProduct);
    }
}
