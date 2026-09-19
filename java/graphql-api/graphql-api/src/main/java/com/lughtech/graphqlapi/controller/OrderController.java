package com.lughtech.graphqlapi.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.lughtech.graphqlapi.fetchers.OrderFetcher;
import com.lughtech.graphqlapi.model.Order;

@Controller 
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderFetcher orderFetcher;
    
    public OrderController(OrderFetcher orderFetcher) {
        this.orderFetcher = orderFetcher;
    }

    @QueryMapping
    public Order findOrderById(@Argument UUID id) {
        log.info("GraphQL query findOrderById called: orderId={}", id);
        Order order = orderFetcher.fetchOrderById(id);
        log.debug("GraphQL query findOrderById completed: orderId={}, found={}", id, order != null);
        return order;
    }

}
