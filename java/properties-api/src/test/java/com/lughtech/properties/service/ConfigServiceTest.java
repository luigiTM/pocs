package com.lughtech.properties.service;

import com.lughtech.properties.config.PropertiesHandler;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class ConfigServiceTest {

    @Mock
    private PropertiesHandler propertiesHandler;

    @InjectMocks
    private ConfigService configService;

    @BeforeEach
    void setup() {
        propertiesHandler = mock(PropertiesHandler.class);
        configService = new ConfigService(propertiesHandler);
    }

    @Test
    void whenConfigServiceInit_thenCallPropertiesHandlerLoadProperties() throws Exception {
        configService.init();
        verify(propertiesHandler, times(1)).loadProperties();
    }

    @Test
    void whenConfigServiceGetAppName_thenCallPropertiesHandlerGetProperty() throws Exception {
        configService.getAppName();
        verify(propertiesHandler, times(1)).getProperty("appName");
    }

    @Test
    void whenConfigServiceSetAppName_thenCallPropertiesHandlerSetPropertyAndWriteProperties() throws Exception {
        configService.setAppName("newName");
        verify(propertiesHandler, times(1)).setProperty("appName", "newName");
        verify(propertiesHandler, times(1)).writeProperties();
    }

    @Test
    void whenConfigServiceRemoveAppName_thenCallPropertiesHandlerRemoveProperty() throws Exception {
        configService.removedAppName();
        verify(propertiesHandler, times(1)).removeProperty("appName");
        verify(propertiesHandler, times(1)).writeProperties();
    }
}
