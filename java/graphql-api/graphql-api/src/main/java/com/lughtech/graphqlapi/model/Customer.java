package com.lughtech.graphqlapi.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public record Customer(
        UUID id,
        String name,
        String email,
        OffsetDateTime createdAt,
        OffsetDateTime updatedAt) {
}
