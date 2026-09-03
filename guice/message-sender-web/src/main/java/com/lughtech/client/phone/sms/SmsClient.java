package com.lughtech.client.phone.sms;

public interface SmsClient {

    void sendSms(String phoneNumber, String content);
    
}
