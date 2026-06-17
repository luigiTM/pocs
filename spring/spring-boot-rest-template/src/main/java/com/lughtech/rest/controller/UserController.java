package com.lughtech.rest.controller;

import com.lughtech.rest.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public void getUser() {
        userService.fetchUser(1);
    }
}
