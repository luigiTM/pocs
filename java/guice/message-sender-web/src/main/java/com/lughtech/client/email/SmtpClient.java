package com.lughtech.client.email;

import java.util.logging.Logger;

public class SmtpClient implements EmailClient {

    private final Logger logger = Logger.getLogger("SmtpClient");

    @Override
    public void sendEmail(String email, String subject, String body) {
        logger.info("Sending email through SMTP to " + email);
    }
    
}
