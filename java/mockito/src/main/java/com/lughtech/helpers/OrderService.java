package com.lughtech.helpers;

public class OrderService {

    private final OrderRepository orderRepository;
    private final NotificationService notificationService;

    public OrderService(OrderRepository orderRepository, NotificationService notificationService) {
        this.orderRepository = orderRepository;
        this.notificationService = notificationService;
    }

    public Order getOrderById(Integer id) {
        return this.orderRepository.getOrderById(id);
    }

    public Order saveOrder(Order order) {
        var createdOrder = this.orderRepository.saveOrder(order);
        this.notificationService.sendNotification("Order created ==> Id: " + createdOrder.id() + ", Description: " + order.description());
        return createdOrder;
    }

    public void deleteOrder(Integer id) {
        this.orderRepository.deleteOrder(id);
    }
}
