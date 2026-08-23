package com.lughtech.endpoint_metrics.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lughtech.endpoint_metrics.domain.User;
import com.lughtech.endpoint_metrics.domain.dto.UserDto;
import com.lughtech.endpoint_metrics.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    public User createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @GetMapping("/{id}")
    public User getMethodName(@PathVariable Integer id) throws InterruptedException {
        return userService.getUser(id);
    }
    
}
