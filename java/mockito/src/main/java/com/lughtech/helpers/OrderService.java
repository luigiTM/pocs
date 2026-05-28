package com.lughtech.helpers;

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order getOrderById(Integer id) {
        return this.orderRepository.getOrderById(id);
    }

    public Order saveOrder(Order order) {
        return this.orderRepository.saveOrder(order);
    }

    public void deleteOrder(Integer id) {
        this.orderRepository.deleteOrder(id);
    }
}
