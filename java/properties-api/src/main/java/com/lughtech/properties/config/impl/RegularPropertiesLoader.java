package com.lughtech.properties.config.impl;

import com.lughtech.properties.config.PropertiesLoader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class RegularPropertiesLoader implements PropertiesLoader {

    private final Properties properties = new Properties();

    @Override
    public void loadProperties() throws IOException {
        String appConfigPath = Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource("app.properties")).getPath();
        properties.load(new FileInputStream(appConfigPath));
    }

    @Override
    public Properties getProperties() {
        return this.properties;
    }
}
