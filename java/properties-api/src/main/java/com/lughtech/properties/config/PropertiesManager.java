package com.lughtech.properties.config;

import java.io.IOException;
import java.util.Properties;

public class PropertiesManager {

    private final PropertiesLoader propertiesLoader;
    private final PropertiesWriter propertiesWriter;

    public PropertiesManager(PropertiesLoader propertiesLoader, PropertiesWriter propertiesWriter) throws IOException {
        this.propertiesLoader = propertiesLoader;
        this.propertiesWriter = propertiesWriter;
        this.loadProperties();
    }

    public void loadProperties() throws IOException {
        this.propertiesLoader.loadProperties();
    }

    public void writeProperties() {
        this.propertiesWriter.writeProperties();
    }

    public Properties getProperties() {
        return this.propertiesLoader.getProperties();
    }

    public void setProperty() {

    }
}
