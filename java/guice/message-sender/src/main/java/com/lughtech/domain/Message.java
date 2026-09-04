package com.lughtech.domain;

public record Message(
    String subject,
    String content,
    Recipient recipient,
    MessageType messageType) {
    
}
