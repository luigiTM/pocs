package com.lughtech.service;

import com.lughtech.domain.Recipient;

public interface MessageService {

    void sendMessage(String Message, Recipient recipient);

}