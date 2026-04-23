package com.lughtech.properties.config.impl;

import com.lughtech.properties.config.PropertiesHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlPropertiesHandler extends PropertiesHandler {

    public XmlPropertiesHandler(String propertiesPath) {
        super(propertiesPath);
    }

    @Override
    public void loadProperties() throws IOException {
        try(var inputStream = new FileInputStream(propertiesPath)) {
            properties.loadFromXML(inputStream);
        }
    }

    @Override
    public void writeProperties() throws IOException {
        try(var fileWriter = new FileOutputStream(propertiesPath)) {
            this.properties.storeToXML(fileWriter, null);
        }
    }

    @Override
    public String getProperty(String key) {
        return this.properties.getProperty(key);
    }

    @Override
    public void setProperty(String property, String value) {
        this.properties.setProperty(property, value);
    }
}
