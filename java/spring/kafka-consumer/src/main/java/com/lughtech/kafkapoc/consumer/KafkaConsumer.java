package com.lughtech.kafkapoc.consumer;

import com.lughtech.kafkapoc.model.Message;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "topic-with-replication", groupId = "poc-consumer-group-1", containerFactory = "autoCommitKafkaListenerContainerFactory")
    public void autoCommitConsume(Message message) {
        System.out.println("message = " + message);
    }

    @KafkaListener(topics = "topic-with-replication", groupId = "poc-consumer-group-2", containerFactory = "manualCommitKafkaListenerContainerFactory")
    public void manualCommitConsume(Message message, Consumer<String, Message> consumer) {
        System.out.println("message = " + message);
        consumer.commitAsync();
    }

}
