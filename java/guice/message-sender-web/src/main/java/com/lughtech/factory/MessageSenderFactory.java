package com.lughtech.factory;

import java.util.Map;

import com.google.inject.Inject;
import com.lughtech.domain.MessageType;
import com.lughtech.sender.MessageSender;

public class MessageSenderFactory {

    private Map<MessageType, MessageSender> senders;

    @Inject
    public MessageSenderFactory(Map<MessageType, MessageSender> senders) {
        this.senders = senders;
    }

    public MessageSender getSender(MessageType messagetype) {
        return senders.get(messagetype);
    }
    
}
