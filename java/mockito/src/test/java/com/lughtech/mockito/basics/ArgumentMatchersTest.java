package com.lughtech.mockito.basics;

import com.lughtech.helpers.OrderRepository;
import com.lughtech.helpers.OrderService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArgumentMatchersTest {

    @Mock
    private OrderRepository orderRepository;

    private OrderService orderService;

    @BeforeAll
    void setup() {
        orderRepository = mock(OrderRepository.class);
        orderService = new OrderService(orderRepository);
    }




}
