package com.lughtech.rest.service;

import com.lughtech.rest.client.ExternalUserClient;
import com.lughtech.rest.dto.user.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ExternalUserClient externalUserClient;

    public UserService(ExternalUserClient externalUserClient) {
        this.externalUserClient = externalUserClient;
    }

    public User fetchUser(Integer id) {
        var externalUser = externalUserClient.fetchExternalUser(id);
        return new User(externalUser.id(), externalUser.name(), externalUser.username(), externalUser.email());
    }

}
