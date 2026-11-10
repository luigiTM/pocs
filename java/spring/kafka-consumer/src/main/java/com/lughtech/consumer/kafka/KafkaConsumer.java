package com.lughtech.consumer.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "poc-consumer", groupId = "poc-consumer")
    public void consume(String message) {
        System.out.println("message = " + message);
    }

}
