package com.lughtech.mockito.basics;

import com.lughtech.helpers.Order;
import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class VerifyInteractionsTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeEach
    void setup() {
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderService(orderRepository);
    }

    @Test
    void shouldCallOneTimeRepositoryGetOrderById() {
        when(orderRepository.getOrderById(1)).thenReturn(new Order(1));
        orderService.getOrderById(1);

        verify(orderRepository, times(1)).getOrderById(1);
        verify(orderRepository, atLeastOnce()).getOrderById(anyInt());
        verify(orderRepository, never()).getOrderById(2);
        verifyNoMoreInteractions(orderRepository);
    }

    @Test
    void shouldCallTwoTimeRepositoryGetOrderById() {
        when(orderRepository.getOrderById(1)).thenReturn(new Order(1));
        when(orderRepository.getOrderById(2)).thenReturn(new Order(2));
        orderService.getOrderById(1);
        orderService.getOrderById(2);

        verify(orderRepository, times(1)).getOrderById(1);
        verify(orderRepository, times(1)).getOrderById(2);
        verify(orderRepository, atLeast(2)).getOrderById(anyInt());
        verify(orderRepository, times(2)).getOrderById(anyInt());
        verifyNoMoreInteractions(orderRepository);
    }

    @Test
    void shouldHaveNoInteractionsWhenMethodIsNotCalled() {
        verify(orderRepository, never()).getOrderById(anyInt());
        verifyNoInteractions(orderRepository);
    }
}
