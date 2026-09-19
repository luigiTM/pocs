package com.lughtech.graphqlapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record Order(
        UUID id,
        UUID customerId,
        OrderStatus status,
        BigDecimal total,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt,
        List<OrderItem> items) {
}
