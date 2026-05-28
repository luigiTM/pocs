package com.lughtech.mockito.advanced;

import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExceptionStubbingTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldThrowRuntimeExceptionWhenGettingOrderById() {
        when(orderRepository.getOrderById(1)).thenThrow(RuntimeException.class);

        assertThrows(RuntimeException.class, () -> orderService.getOrderById(1));
    }

    @Test
    void shouldThrowRuntimeExceptionWithMessageWhenGettingOrderById() {
        when(orderRepository.getOrderById(1)).thenThrow(new RuntimeException("An error occurred"));

        var exception = assertThrows(RuntimeException.class, () -> orderService.getOrderById(1));
        assertEquals("An error occurred", exception.getMessage());
    }

    @Test
    void shouldThrowRuntimeExceptionWhenDeletingOrderById() {
        doThrow(RuntimeException.class).when(orderRepository).deleteOrder(1);

        assertThrows(RuntimeException.class, () -> orderService.deleteOrder(1));
    }

}
