package com.lughtech.endpoint_metrics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lughtech.endpoint_metrics.domain.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
