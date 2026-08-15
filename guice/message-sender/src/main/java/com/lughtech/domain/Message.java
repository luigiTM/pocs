package com.lughtech.domain;

public record Message(String content, MessageType messageType, Recipient recipient) {
    
}
