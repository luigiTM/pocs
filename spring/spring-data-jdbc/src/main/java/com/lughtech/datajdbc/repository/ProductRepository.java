package com.lughtech.datajdbc.repository;

import com.lughtech.datajdbc.model.Product;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByActiveTrue();

    List<Product> findByPriceGreaterThan(BigDecimal price);

    @Query("SELECT * FROM product WHERE LOWER(name) LIKE LOWER(CONCAT('%', :name, '%'))")
    List<Product> searchByName(String name);

}
