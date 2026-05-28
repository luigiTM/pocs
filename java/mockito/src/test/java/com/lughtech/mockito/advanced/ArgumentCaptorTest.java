package com.lughtech.mockito.advanced;

import com.lughtech.helpers.Order;
import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptorTest {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderService orderService;

    @Captor
    ArgumentCaptor<Order> orderCaptor;

    @Test
    void shouldValidateOrderInformation() {
        var order = new Order(1, "This is a description");
        orderService.saveOrder(order);

        verify(orderRepository).saveOrder(orderCaptor.capture());
        var capturedOrder = orderCaptor.getValue();
        assertEquals(1, capturedOrder.id());
        assertEquals("This is a description", capturedOrder.description());
    }

}
