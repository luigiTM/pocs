package com.lughtech.graphqlapi.controller;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.lughtech.graphqlapi.fetchers.OrderFetcher;
import com.lughtech.graphqlapi.fetchers.PaymentFetcher;
import com.lughtech.graphqlapi.model.Order;
import com.lughtech.graphqlapi.model.Payment;

@Controller 
public class OrderController {

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    private final OrderFetcher orderFetcher;
    private final PaymentFetcher paymentFetcher;
    
    public OrderController(OrderFetcher orderFetcher, PaymentFetcher paymentFetcher) {
        this.orderFetcher = orderFetcher;
        this.paymentFetcher = paymentFetcher;
    }

    @QueryMapping
    public Order findOrderById(@Argument UUID id) {
        log.info("GraphQL query findOrderById called: orderId={}", id);
        Order order = orderFetcher.fetchOrderById(id);
        log.debug("GraphQL query findOrderById completed: orderId={}, found={}", id, order != null);
        return order;
    }

    @SchemaMapping(typeName = "Order", field = "payment")
    public Payment findPaymentByOrderId(Order order) {
        log.info("Resolving Order.payment: orderId={}", order.id());
        Payment payment = paymentFetcher.fetchPaymentByOrderId(order.id());
        log.debug("Resolved Order.payment: orderId={}, found={}", order.id(), payment != null);
        return payment;
    }

}
