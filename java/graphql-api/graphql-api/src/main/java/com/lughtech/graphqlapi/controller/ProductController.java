package com.lughtech.graphqlapi.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.lughtech.graphqlapi.fetchers.ProductFetcher;
import com.lughtech.graphqlapi.model.OrderItem;
import com.lughtech.graphqlapi.model.Product;

@Controller
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    private final ProductFetcher productFetcher;

    public ProductController(ProductFetcher productFetcher) {
        this.productFetcher = productFetcher;
    }
    
    @QueryMapping 
    public Product findProductById(@Argument UUID id) {
        log.info("GraphQL query findProductById called: productId={}", id);
        Product product = productFetcher.fetchProductById(id);
        log.debug("GraphQL query findProductById completed: productId={}, found={}", id, product != null);
        return product;
    }

    @SchemaMapping(typeName = "OrderItem", field = "product")
    public Product product(OrderItem orderItem) {
        log.info("Resolving OrderItem.product: orderItemId={}, productId={}",
                orderItem.id(),
                orderItem.productId());
        Product product = productFetcher.fetchProductById(orderItem.productId());
        log.debug("Resolved OrderItem.product: orderItemId={}, productId={}, found={}",
                orderItem.id(),
                orderItem.productId(),
                product != null);
        return product;
    }
}
