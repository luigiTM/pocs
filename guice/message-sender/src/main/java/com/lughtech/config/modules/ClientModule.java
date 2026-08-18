package com.lughtech.config.modules;

import com.google.inject.AbstractModule;
import com.lughtech.client.email.EmailClient;
import com.lughtech.client.email.SmtpClient;
import com.lughtech.client.phone.TwillioClient;
import com.lughtech.client.phone.sms.SmsClient;
import com.lughtech.client.phone.whatsapp.WhatsappClient;

public class ClientModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(EmailClient.class).to(SmtpClient.class);
        bind(SmsClient.class).to(TwillioClient.class);
        bind(WhatsappClient.class).to(TwillioClient.class);
    }
    
}
