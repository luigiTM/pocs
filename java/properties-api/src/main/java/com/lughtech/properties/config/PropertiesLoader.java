package com.lughtech.properties.config;

import java.io.IOException;
import java.util.Properties;

public interface PropertiesLoader {

    void loadProperties() throws IOException;

    Properties getProperties();

}
