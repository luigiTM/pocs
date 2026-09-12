package com.lughtech.productservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lughtech.productservice.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
