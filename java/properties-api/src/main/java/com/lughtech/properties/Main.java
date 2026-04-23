package com.lughtech.properties;

import com.lughtech.properties.config.PropertiesLoader;
import com.lughtech.properties.config.PropertiesManager;
import com.lughtech.properties.config.PropertiesWriter;
import com.lughtech.properties.config.impl.RegularPropertiesLoader;
import com.lughtech.properties.config.impl.RegularPropertiesWriter;
import com.lughtech.properties.service.ConfigService;

import java.io.IOException;

public class Main {

    static void main() throws IOException {
        // Regular properties
        PropertiesLoader regularPropertiesLoader = new RegularPropertiesLoader();
        PropertiesWriter regularPropertiesWriter = new RegularPropertiesWriter();

        PropertiesManager propertiesManager = new PropertiesManager(regularPropertiesLoader, regularPropertiesWriter);
        ConfigService configService = new ConfigService(propertiesManager);
        System.out.println("AppName: " + configService.getAppName());
    }
}
