package com.lughtech.rest.service;

import com.lughtech.rest.client.ExternalUserClient;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final ExternalUserClient externalUserClient;

    public UserService(ExternalUserClient externalUserClient) {
        this.externalUserClient = externalUserClient;
    }

    public void fetchUser(Integer id) {
        var externalUser = externalUserClient.fetchExternalUser(id);
    }

}
