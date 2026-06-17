package com.lughtech.rest.dto.externaluser;

public record Address(
        String street,
        String suite,
        String city,
        String zipcode,
        Geo geo
) {
}
