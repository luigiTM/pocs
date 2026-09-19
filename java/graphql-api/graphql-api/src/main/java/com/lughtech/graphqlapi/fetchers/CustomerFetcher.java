package com.lughtech.graphqlapi.fetchers;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lughtech.graphqlapi.schema.Customer;

@Component 
public class CustomerFetcher {

    private static final String URL = "http://localhost:8091/api/v1/customer";
    private final RestTemplate restTemplate;

    public CustomerFetcher(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Customer fetchCustomerById(String id) {
        var response = restTemplate.getForEntity(URL + "/" + id, Customer.class);
        return response.getBody();
    }
    
}
