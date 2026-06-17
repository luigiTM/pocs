package com.lughtech.rest.client;

import com.lughtech.rest.dto.externaluser.ExternalUser;
import org.springframework.web.client.RestTemplate;

public class ExternalUserClient {

    public static final String URL = "https://jsonplaceholder.typicode.com/users/";
    private final RestTemplate restTemplate;

    public ExternalUserClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ExternalUser fetchExternalUser(Integer id) {
        var response = restTemplate
                .getForEntity(URL + id, ExternalUser.class);
        // Add validations
        return response.getBody();
    }

}
