package com.lughtech.mockito.advanced;

import com.lughtech.helpers.NotificationService;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ArgumentCaptorTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private OrderService orderService;

    @Captor
    ArgumentCaptor<Order> orderCaptor;

    @Test
    void shouldValidateOrderInformation() {
        var order = new Order(null, "This is a description");
        when(orderRepository.saveOrder(order)).thenReturn(new Order(1, "This is a description"));
        orderService.saveOrder(order);

        verify(orderRepository).saveOrder(orderCaptor.capture());
        var capturedOrder = orderCaptor.getValue();
        assertEquals(null, capturedOrder.id());
        assertEquals("This is a description", capturedOrder.description());
    }

}
