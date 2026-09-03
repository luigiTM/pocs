package com.lughtech.service;

import com.google.inject.Inject;
import com.lughtech.domain.Message;
import com.lughtech.factory.MessageSenderFactory;
import com.lughtech.sender.MessageSender;

public class MessageService {

    private final MessageSenderFactory factory;

    @Inject
    public MessageService(MessageSenderFactory factory) {
        this.factory = factory;
    }


    public void sendMessage(Message message) {
        MessageSender sender = factory.getSender(message.messageType());
        if (sender == null) {
            throw new RuntimeException("Sender not implemented for message type -> " + message.messageType());
        }
        sender.send(message);
    }
    
}
