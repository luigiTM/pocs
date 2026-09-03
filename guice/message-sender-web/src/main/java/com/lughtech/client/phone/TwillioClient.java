package com.lughtech.client.phone;

import java.util.logging.Logger;

import com.lughtech.client.phone.sms.SmsClient;
import com.lughtech.client.phone.whatsapp.WhatsappClient;

public class TwillioClient implements SmsClient, WhatsappClient {

    private final Logger logger = Logger.getLogger("TwillioClient");

    @Override
    public void sendSms(String phoneNumber, String content) {
        logger.info("Sending SMS through Twillio to " + phoneNumber);
    }

    @Override
    public void sendWhatsappMessage(String phoneNumber, String content) {
        logger.info("Sending WhatsApp message to " + phoneNumber);
    }
    
}
