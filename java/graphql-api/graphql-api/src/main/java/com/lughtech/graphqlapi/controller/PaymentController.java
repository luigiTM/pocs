package com.lughtech.graphqlapi.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.lughtech.graphqlapi.fetchers.PaymentFetcher;
import com.lughtech.graphqlapi.model.Payment;

@Controller
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);

    private final PaymentFetcher paymentFetcher;

    public PaymentController(PaymentFetcher paymentFetcher) {
        this.paymentFetcher = paymentFetcher;
    }

    @QueryMapping 
    public Payment findPaymentById(@Argument UUID id) {
        log.info("GraphQL query findPaymentById called: paymentId={}", id);
        Payment payment = paymentFetcher.fetchPaymentById(id);
        log.debug("GraphQL query findPaymentById completed: paymentId={}, found={}", id, payment != null);
        return payment;
    }
    
}
