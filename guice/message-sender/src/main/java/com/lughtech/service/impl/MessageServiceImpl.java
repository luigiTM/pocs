package com.lughtech.service.impl;

import com.google.inject.Inject;
import com.lughtech.domain.Message;
import com.lughtech.domain.MessageType;
import com.lughtech.domain.Recipient;
import com.lughtech.factory.MessageSenderFactory;
import com.lughtech.sender.MessageSender;
import com.lughtech.service.MessageService;

public class MessageServiceImpl implements MessageService {

    private MessageSenderFactory factory;

    @Inject
    public MessageServiceImpl(MessageSenderFactory factory) {
        this.factory = factory;
    }

    @Override
    public void sendMessage(String subject, String content, Recipient recipient, MessageType messageType) {
        MessageSender sender = factory.getSender(messageType);
        if (sender == null) {
            throw new RuntimeException("Sender not implemented for message type -> " + messageType.name());
        }
        Message message = new Message(subject, content, recipient, messageType);
        sender.send(message);
    }
    
}
