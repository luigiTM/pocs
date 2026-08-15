package com.lughtech;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lughtech.config.modules.AppModule;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule());
    }
    
}
