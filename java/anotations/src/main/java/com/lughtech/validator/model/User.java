package com.lughtech.validator.model;

import com.lughtech.validator.annotations.Email;
import com.lughtech.validator.annotations.MinLength;
import com.lughtech.validator.annotations.NotNull;

public class User {

    @NotNull()
    @MinLength(5)
    private final String username;

    @NotNull()
    @MinLength(7)
    @Email
    private final String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
