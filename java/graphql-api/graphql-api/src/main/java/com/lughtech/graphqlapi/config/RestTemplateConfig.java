package com.lughtech.graphqlapi.config;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.springframework.boot.restclient.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder
                .connectTimeout(Duration.of(5, ChronoUnit.SECONDS))
                .build();
    }
}
