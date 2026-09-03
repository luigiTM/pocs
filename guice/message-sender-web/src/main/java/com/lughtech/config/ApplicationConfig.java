package com.lughtech.config;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lughtech.api.MessageController;

import com.lughtech.config.modules.ClientModule;
import com.lughtech.config.modules.SenderModule;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    @Bean
    ServletRegistrationBean<MessageController> messageController(Injector injector) {
        return new ServletRegistrationBean<>(injector.getInstance(MessageController.class), "/messages");
    }

    @Bean
    Injector injector() {
        return Guice.createInjector(
                new ClientModule(),
                new SenderModule()
        );
    }
}
