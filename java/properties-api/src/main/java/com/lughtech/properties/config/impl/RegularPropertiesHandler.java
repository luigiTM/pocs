package com.lughtech.properties.config.impl;

import com.lughtech.properties.config.PropertiesHandler;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class RegularPropertiesHandler extends PropertiesHandler {


    public RegularPropertiesHandler(String propertiesPath) {
        super(propertiesPath);
    }

    @Override
    public void loadProperties() throws IOException {
        try(var inputStream = new FileInputStream(propertiesPath)) {
            properties.load(inputStream);
        }
    }

    @Override
    public void writeProperties() throws IOException {
        try(var fileWriter = new FileWriter(propertiesPath)) {
            this.properties.store(fileWriter, null);
        }
    }


}
