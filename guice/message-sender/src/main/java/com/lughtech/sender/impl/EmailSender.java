package com.lughtech.sender.impl;

import com.google.inject.Inject;
import com.lughtech.client.email.EmailClient;
import com.lughtech.domain.Message;
import com.lughtech.sender.MessageSender;

public class EmailSender implements MessageSender {

    private EmailClient emailClient;

    @Inject
    public EmailSender(EmailClient emailClient) {
        this.emailClient = emailClient;
    }

    @Override
    public void send(Message message) {
        this.emailClient.sendEmail(message.recipient().email(), message.subject(), message.content());
    }
    
}
