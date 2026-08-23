package com.lughtech.endpoint_metrics.service;

import org.springframework.stereotype.Service;

import com.lughtech.endpoint_metrics.domain.User;
import com.lughtech.endpoint_metrics.domain.dto.UserDto;
import com.lughtech.endpoint_metrics.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDto userDto) {
        User user = new User(null, userDto.name(), userDto.email());
        return userRepository.save(user);
    }

    public User getUser(Integer id) throws InterruptedException {
        Thread.sleep(2500);
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }
    
}
