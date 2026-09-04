package com.lughtech.sender.impl;

import com.google.inject.Inject;
import com.lughtech.client.phone.sms.SmsClient;
import com.lughtech.domain.Message;
import com.lughtech.sender.MessageSender;

public class SmsSender implements MessageSender{

    private SmsClient smsClient;

    @Inject
    public SmsSender(SmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @Override
    public void send(Message message) {
        this.smsClient.sendSms(message.recipient().phoneNumber(), message.content());
    }
    
}
