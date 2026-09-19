package com.lughtech.graphqlapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record OrderItem(
        UUID id,
        UUID productId,
        Integer quantity,
        BigDecimal unitPrice,
        OffsetDateTime createdAt) {
}
