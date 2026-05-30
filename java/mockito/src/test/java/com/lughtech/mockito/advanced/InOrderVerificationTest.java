package com.lughtech.mockito.advanced;

import com.lughtech.helpers.NotificationService;
import com.lughtech.helpers.Order;
import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InOrderVerificationTest {

    @Mock
    private OrderRepository orderRepository;

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private OrderService orderService;

    @Test
    void shouldVerifyThatOrderIsSavedThenNotificationIsSent() {
        var order = new Order(null, "Order description");
        when(orderRepository.saveOrder(order)).thenReturn(new Order(1, "Order description"));
        orderService.saveOrder(order);

        InOrder inOrder = inOrder(orderRepository, notificationService);
        inOrder.verify(orderRepository).saveOrder(order);
        inOrder.verify(notificationService).sendNotification("Order created ==> Id: 1, Description: Order description");
        inOrder.verifyNoMoreInteractions();
    }


}
