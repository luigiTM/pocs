package com.lughtech.properties.service;

import com.lughtech.properties.config.PropertiesHandler;

import java.io.IOException;

public class ConfigService {

    private final PropertiesHandler propertiesHandler;

    public ConfigService(PropertiesHandler propertiesHandler) throws IOException {
        this.propertiesHandler = propertiesHandler;
        this.propertiesHandler.loadProperties();
    }

    public String getAppName() {
        return this.propertiesHandler.getProperty("appName");
    }

    public void setAppName(String newValue) throws IOException {
        this.propertiesHandler.setProperty("appName", newValue);
        this.propertiesHandler.writeProperties();
    }

    public void removedProperty(String key) throws IOException {
        this.propertiesHandler.removeProperty(key);
        this.propertiesHandler.writeProperties();
    }

}
