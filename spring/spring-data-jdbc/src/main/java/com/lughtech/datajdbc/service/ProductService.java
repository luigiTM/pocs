package com.lughtech.datajdbc.service;

import com.lughtech.datajdbc.model.Product;
import com.lughtech.datajdbc.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product create(Product product) {
        return this.productRepository.save(product);
    }

    public Iterable<Product> getAll() {
        return this.productRepository.findAll();
    }

    public List<Product> findActive() {
        return this.productRepository.findByActiveTrue();
    }

    public List<Product> searchByName(String name) {
        return this.productRepository.searchByName(name);
    }

    public void delete(Long id) {
        this.productRepository.deleteById(id);
    }

}
