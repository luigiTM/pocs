package com.lughtech.properties;

import com.lughtech.properties.config.PropertiesHandler;
import com.lughtech.properties.config.impl.RegularPropertiesHandler;
import com.lughtech.properties.config.impl.XmlPropertiesHandler;
import com.lughtech.properties.service.ConfigService;

import java.io.IOException;
import java.util.Objects;

public class Main {

    static void main() throws IOException {

        String regularPropertiesPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("app.properties")).getPath();
        String xmlPropertiesPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("app.xml")).getPath();

        // Regular properties
        PropertiesHandler regularPropertiesHandler = new RegularPropertiesHandler(regularPropertiesPath);

        //XML properties
        PropertiesHandler xmlPropertiesHandler = new XmlPropertiesHandler(xmlPropertiesPath);

        ConfigService configService = new ConfigService(xmlPropertiesHandler);

        configService.init();

        System.out.println("AppName: " + configService.getAppName());

        configService.setAppName("NewAppName");

        configService.removedAppName();
    }
}
