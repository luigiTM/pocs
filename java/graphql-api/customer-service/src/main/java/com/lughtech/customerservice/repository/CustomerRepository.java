package com.lughtech.customerservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lughtech.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
    
}
