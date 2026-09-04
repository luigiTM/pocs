package com.lughtech.config.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.lughtech.service.MessageService;
import com.lughtech.service.impl.MessageServiceImpl;

public class AppModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageService.class).to(MessageServiceImpl.class).in(Scopes.SINGLETON);;
    }
    
}
