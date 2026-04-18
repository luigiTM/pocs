package com.lughtech.properties.config;

public class PropertiesManager {

    private final PropertiesLoader propertiesLoader;
    private final PropertiesWriter propertiesWriter;

    public PropertiesManager(PropertiesLoader propertiesLoader, PropertiesWriter propertiesWriter) {
        this.propertiesLoader = propertiesLoader;
        this.propertiesWriter = propertiesWriter;
    }

    public void loadConfiguration() {
        this.propertiesLoader.loadProperties();
    }

    public void writeConfiguration() {
        this.propertiesWriter.writeProperties();
    }

    public void getConfiguration() {

    }

    public void setConfiguration() {

    }
}
