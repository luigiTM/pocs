package com.lughtech.service;

import com.lughtech.domain.MessageType;
import com.lughtech.domain.Recipient;

public interface MessageService {

    void sendMessage(String subject, String content, Recipient recipient, MessageType messageType);

}