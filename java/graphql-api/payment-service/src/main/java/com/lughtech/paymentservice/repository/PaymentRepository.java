package com.lughtech.paymentservice.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lughtech.paymentservice.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
