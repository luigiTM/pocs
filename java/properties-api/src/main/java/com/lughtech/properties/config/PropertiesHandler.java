package com.lughtech.properties.config;

import java.io.IOException;
import java.util.Properties;

public abstract class PropertiesHandler {

    protected final String propertiesPath;
    protected final Properties properties = new Properties();

    protected PropertiesHandler(String propertiesPath) {
        this.propertiesPath = propertiesPath;
    }

    abstract public void loadProperties() throws IOException;

    abstract public void writeProperties() throws IOException;

    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    public void setProperty(String property, String value) {
        this.properties.setProperty(property, value);
    }

    public void removeProperty(String key) {
        this.properties.remove(key);
    }

}
