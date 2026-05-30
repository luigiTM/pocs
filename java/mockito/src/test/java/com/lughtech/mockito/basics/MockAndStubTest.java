package com.lughtech.mockito.basics;

import com.lughtech.helpers.NotificationService;
import com.lughtech.helpers.Order;
import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MockAndStubTest {

    private OrderRepository orderRepository;

    private NotificationService notificationService;

    private OrderService orderService;

    @BeforeAll
    void setup() {
        orderRepository = mock(OrderRepository.class);
        notificationService = mock(NotificationService.class);
        orderService = new OrderService(orderRepository, notificationService);
    }

    @Test
    void shouldReturnOrderWhenUsingGetIdOne() {
        when(orderRepository.getOrderById(1)).thenReturn(new Order(1, "description"));
        var order = orderService.getOrderById(1);

        assertNotNull(order);
        assertEquals(1, order.id());
    }

    @Test
    void shouldReturnOrderWhenUsingGetIdTwo() {
        when(orderRepository.getOrderById(2)).thenReturn(new Order(2, "description"));
        var order = orderService.getOrderById(2);

        assertNotNull(order);
        assertEquals(2, order.id());
    }

    @Test
    void shouldReturnNullWhenUsingGetIdThree() {
        when(orderRepository.getOrderById(3)).thenReturn(null);
        var order = orderService.getOrderById(3);

        assertNull(order);
    }

}
