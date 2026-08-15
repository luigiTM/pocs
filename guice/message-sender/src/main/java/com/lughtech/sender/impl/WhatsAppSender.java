package com.lughtech.sender.impl;

import org.apache.logging.log4j.Logger;

import com.google.inject.Inject;
import com.lughtech.domain.Message;
import com.lughtech.sender.MessageSender;

public class WhatsAppSender implements MessageSender {

    @Inject
    private Logger logger;

    @Override
    public void sender(Message message) {
        var info = "Sending message to " + message.recipient().phoneNumber() + " through whatsapp";
        logger.info(info);
    }
    
}
