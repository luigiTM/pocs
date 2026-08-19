package com.lughtech.config.modules;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.MapBinder;
import com.lughtech.domain.MessageType;
import com.lughtech.sender.MessageSender;
import com.lughtech.sender.impl.EmailSender;
import com.lughtech.sender.impl.SmsSender;
import com.lughtech.sender.impl.WhatsAppSender;

public class SenderModule extends AbstractModule {

    @Override
    protected void configure() {
        MapBinder<MessageType, MessageSender> senderMapBinder = 
        MapBinder.newMapBinder(binder(), MessageType.class, MessageSender.class);

        senderMapBinder.addBinding(MessageType.EMAIL).to(EmailSender.class).in(Scopes.SINGLETON);
        senderMapBinder.addBinding(MessageType.SMS).to(SmsSender.class).in(Scopes.SINGLETON);
        senderMapBinder.addBinding(MessageType.WHATSAPP).to(WhatsAppSender.class).in(Scopes.SINGLETON);
    }
    
}
