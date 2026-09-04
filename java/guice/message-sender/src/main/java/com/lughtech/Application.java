package com.lughtech;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.lughtech.config.modules.AppModule;
import com.lughtech.config.modules.ClientModule;
import com.lughtech.config.modules.SenderModule;
import com.lughtech.domain.MessageType;
import com.lughtech.domain.Recipient;
import com.lughtech.service.MessageService;

public class Application {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new AppModule(), new ClientModule(), new SenderModule());
        MessageService messageService = injector.getInstance(MessageService.class);
        messageService.sendMessage("Guice PoC", "Hi Guice", new Recipient("test@me.com", "554899999-9999"), MessageType.EMAIL);
        messageService.sendMessage("", "Hi Guice", new Recipient("test@me.com", "554899999-9999"), MessageType.SMS);
        messageService.sendMessage("", "Hi Guice", new Recipient("test@me.com", "554899999-9999"), MessageType.WHATSAPP);
    }
    
}
