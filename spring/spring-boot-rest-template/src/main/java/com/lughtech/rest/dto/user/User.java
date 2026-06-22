package com.lughtech.rest.dto.user;

public record User(
        Long id,
        String name,
        String username,
        String email) {
}
