package com.lughtech.paymentservice.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lughtech.paymentservice.model.Payment;
import com.lughtech.paymentservice.service.PaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> findAll() {
        return paymentService.findAll();
    }

    @GetMapping("/{id}")
    public Payment findById(@PathVariable UUID id) {
        return paymentService.findById(id);
    }

    @GetMapping("/order/{orderId}")
    public Payment findByOrderId(@PathVariable UUID orderId) {
        return paymentService.findByOrderId(orderId);
    }
}
