package com.lughtech.rest.dto.externaluser;

public record ExternalUser(
        Long id,
        String name,
        String username,
        String email,
        Address address,
        String phone,
        String website,
        Company company
) {
}
