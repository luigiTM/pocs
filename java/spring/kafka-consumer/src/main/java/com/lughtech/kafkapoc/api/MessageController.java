package com.lughtech.kafkapoc.api;

import com.lughtech.kafkapoc.model.Message;
import com.lughtech.kafkapoc.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/")
    public ResponseEntity<Void> createMessage() {
        Message newMessage = new Message(UUID.randomUUID(), "New message");
        kafkaProducer.sendMessage(newMessage);
        return ResponseEntity.ok().build();
    }
}
