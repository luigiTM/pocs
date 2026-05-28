package com.lughtech.helpers;

import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    private final Map<Integer, Order> inMemoryStore;

    public OrderRepository() {
        this.inMemoryStore = new HashMap<>();
    }

    public Order getOrderById(Integer id) {
        return this.inMemoryStore.get(id);
    }

    public Order saveOrder(Order order) {
        var id = this.inMemoryStore.keySet().stream().max((a,b) ->  b - a).orElse(0) + 1;
        var savedOrder = new Order(id, order.description());
        this.inMemoryStore.put(id, savedOrder);
        return savedOrder;
    }

    public void deleteOrder(Integer id) {
        this.inMemoryStore.remove(id);
    }
}
