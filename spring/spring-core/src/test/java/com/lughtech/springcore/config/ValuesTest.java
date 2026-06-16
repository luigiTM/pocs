package com.lughtech.springcore.config;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValuesTest {

    @Test
    void shouldGetValuesFromContext() {
        try (var context = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var values = context.getBean(Values.class);

            assertEquals("Spring Core POC", values.getAppName());
            assertEquals(3, values.getMaxRetries());
            assertEquals(30000, values.getTimeout());
            assertEquals(0.175, values.getTaxRate());
            assertEquals(true, values.getFeatureEnabled());
            assertThat(values.getSupportedLanguages(), is(Arrays.asList("pt-BR", "en-US")));
            assertThat(
                    Map.of("Content-Type", "application/json",
                            "Accept", "application/json",
                            "X-App", "poc"),
                    is(values.getHeaders()));
        }
    }
}
