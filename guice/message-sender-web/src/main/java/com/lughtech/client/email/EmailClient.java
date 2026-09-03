package com.lughtech.client.email;

public interface EmailClient {

    void sendEmail(String email, String subject, String body);
    
}
