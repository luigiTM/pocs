package com.lughtech.graphqlapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.lughtech.graphqlapi.fetchers.CustomerFetcher;
import com.lughtech.graphqlapi.fetchers.OrderFetcher;
import com.lughtech.graphqlapi.model.Customer;
import com.lughtech.graphqlapi.model.Order;

@Controller 
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);

    private final CustomerFetcher customerFetcher;
    private final OrderFetcher orderFetcher;

    public CustomerController(CustomerFetcher customerFetcher, OrderFetcher orderFetcher) {
        this.customerFetcher = customerFetcher;
        this.orderFetcher = orderFetcher;
    }

    @QueryMapping 
    public Customer findCustomerById(@Argument String id) {
        log.info("GraphQL query findCustomerById called: customerId={}", id);
        Customer customer = customerFetcher.fetchCustomerById(id);
        log.debug("GraphQL query findCustomerById completed: customerId={}, found={}", id, customer != null);
        return customer;
    }

    @SchemaMapping
    public List<Order> orders(Customer customer) {
        log.info("Resolving Customer.orders: customerId={}", customer.id());
        List<Order> orders = orderFetcher.fetchOrdersByCustomerId(customer.id());
        log.debug("Resolved Customer.orders: customerId={}, orderCount={}", customer.id(), orders.size());
        return orders;
    }
    
}
