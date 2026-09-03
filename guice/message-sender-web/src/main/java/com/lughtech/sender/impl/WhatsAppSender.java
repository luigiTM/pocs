package com.lughtech.sender.impl;

import com.google.inject.Inject;
import com.lughtech.client.phone.whatsapp.WhatsappClient;
import com.lughtech.domain.Message;
import com.lughtech.sender.MessageSender;

public class WhatsAppSender implements MessageSender {

    private WhatsappClient whatsappClient;

    @Inject
    public WhatsAppSender(WhatsappClient whatsappClient) {
        this.whatsappClient = whatsappClient;
    }

    @Override
    public void send(Message message) {
        this.whatsappClient.sendWhatsappMessage(message.recipient().phoneNumber(), message.content());
    }
    
}
