package com.lughtech.mockito.basics;

import com.lughtech.helpers.NotificationService;
import com.lughtech.helpers.Order;
import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class ArgumentMatchersTest {

    private OrderRepository orderRepository;

    private NotificationService notificationService;

    private OrderService orderService;

    @BeforeEach
    void setup() {
        orderRepository = mock(OrderRepository.class);
        notificationService = mock(NotificationService.class);
        orderService = new OrderService(orderRepository, notificationService);
    }

    @Test
    void shouldReturnOrderGivenAnyArgument() {
        when(orderRepository.getOrderById(any())).thenReturn(new Order(1, "description"));
        var order1 = orderService.getOrderById(1);
        var order2 = orderService.getOrderById(2);
        var order3 = orderService.getOrderById(3);

        assertNotNull(order1);
        assertEquals(1, order1.id());
        assertNotNull(order2);
        assertEquals(1, order2.id());
        assertNotNull(order3);
        assertEquals(1, order3.id());
    }

    @Test
    void shouldReturnOrderGivenAnyIntArgument() {
        when(orderRepository.getOrderById(anyInt())).thenReturn(new Order(1, "description"));
        var order1 = orderService.getOrderById(1);
        var order2 = orderService.getOrderById(2);
        var order3 = orderService.getOrderById(3);

        assertNotNull(order1);
        assertEquals(1, order1.id());
        assertNotNull(order2);
        assertEquals(1, order2.id());
        assertNotNull(order3);
        assertEquals(1, order3.id());
    }

    @Test
    void shouldReturnMultipleOrdersGivenAnyIntArgument() {
        when(orderRepository.getOrderById(anyInt())).thenReturn(new Order(1, "Order 1"), new Order(2, "Order 2"), new Order(3, "Order 3"));
        var order1 = orderService.getOrderById(1);
        var order2 = orderService.getOrderById(2);
        var order3 = orderService.getOrderById(3);

        assertNotNull(order1);
        assertEquals(1, order1.id());
        assertNotNull(order2);
        assertEquals(2, order2.id());
        assertNotNull(order3);
        assertEquals(3, order3.id());
    }

    @Test
    void shouldVerifyThatMethodWasCalledWithParameter() {
        when(orderRepository.getOrderById(anyInt())).thenReturn(new Order(1, "description"));
        orderService.getOrderById(1);
        verify(orderRepository).getOrderById(eq(1));
        orderService.getOrderById(2);
        verify(orderRepository).getOrderById(eq(2));
        orderService.getOrderById(3);
        verify(orderRepository).getOrderById(eq(3));
    }

}
