package com.lughtech.mockito.basics;

import com.lughtech.helpers.Order;
import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SpyTest {

    @Spy
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    void setup() {
        orderService = new OrderService(orderRepository);
    }

    @Test
    void shouldReturnStubbedValueFromRepository() {
        doReturn(new Order(1, "description")).when(orderRepository).getOrderById(1);
        var order = orderService.getOrderById(1);

        verify(orderRepository, times(1)).getOrderById(1);
        assertNotNull(order);
        assertEquals(1, order.id());
    }

    @Test
    void shouldCallRealMethodFromRepository() {
        var order1 = new Order(null, "Order 1");
        var order2 = new Order(null, "Order 2");
        orderRepository.saveOrder(order1);
        orderRepository.saveOrder(order2);
        var returnedOrder1 = orderService.getOrderById(1);
        var returnedOrder2 = orderService.getOrderById(2);

        verify(orderRepository, times(1)).saveOrder(order1);
        verify(orderRepository, times(1)).saveOrder(order2);
        verify(orderRepository, times(1)).getOrderById(1);
        verify(orderRepository, times(1)).getOrderById(2);
        assertNotNull(returnedOrder1);
        assertNotNull(returnedOrder2);
        assertEquals(1, returnedOrder1.id());
        assertEquals("Order 1", returnedOrder1.description());
        assertEquals(2, returnedOrder2.id());
        assertEquals("Order 2", returnedOrder2.description());
    }
}
