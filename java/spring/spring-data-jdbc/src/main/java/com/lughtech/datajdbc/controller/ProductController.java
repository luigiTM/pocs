package com.lughtech.datajdbc.controller;

import com.lughtech.datajdbc.model.Product;
import com.lughtech.datajdbc.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.getAll();
    }

    @GetMapping("/active")
    public List<Product> findActive() {
        return productService.findActive();
    }

    @GetMapping("/search")
    public List<Product> search(@RequestParam String name) {
        return productService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productService.delete(id);
    }
}
