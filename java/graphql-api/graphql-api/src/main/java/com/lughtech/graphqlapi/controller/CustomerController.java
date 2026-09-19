package com.lughtech.graphqlapi.controller;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.lughtech.graphqlapi.fetchers.CustomerFetcher;
import com.lughtech.graphqlapi.schema.Customer;

@Controller 
public class CustomerController {

    private final CustomerFetcher customerFetcher;

    public CustomerController(CustomerFetcher customerFetcher) {
        this.customerFetcher = customerFetcher;
    }

    @QueryMapping 
    public Customer findCustomerById(@Argument String id) {
        return customerFetcher.fetchCustomerById(id);
    }
    
}
