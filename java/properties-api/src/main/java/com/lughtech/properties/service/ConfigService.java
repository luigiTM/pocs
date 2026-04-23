package com.lughtech.properties.service;

import com.lughtech.properties.config.PropertiesManager;

public class ConfigService {

    private final PropertiesManager propertiesManager;

    public ConfigService(PropertiesManager propertiesManager) {
        this.propertiesManager = propertiesManager;
    }

    public String getAppName() {
        return this.propertiesManager.getProperties().getProperty("appName");
    }

}
