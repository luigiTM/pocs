package com.lughtech.graphqlapi.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

public record Product(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        Integer stock,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
