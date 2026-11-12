package com.lughtech.kafkapoc.consumer;

import com.lughtech.kafkapoc.model.Message;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class KafkaConsumer {

    private final Map<String, Set<UUID>> consumedMessagesByConsumerGroup = new HashMap<>();

    @KafkaListener(topics = "topic-with-replication", groupId = "poc-consumer-group-1", containerFactory = "autoCommitKafkaListenerContainerFactory")
    public void autoCommitConsume(Message message) {
        Set<UUID> consumedMessages = consumedMessagesByConsumerGroup.computeIfAbsent("poc-consumer-group-1", k -> new HashSet<>());
        if (consumedMessages.contains(message.id())) {
            System.out.println("Message already consumed, skipping...");
            return;
        }
        System.out.println("message = " + message);
        consumedMessages.add(message.id());
    }

    @KafkaListener(topics = "topic-with-replication", groupId = "poc-consumer-group-2", containerFactory = "manualCommitKafkaListenerContainerFactory")
    public void manualCommitConsume(Message message, Consumer<String, Message> consumer) {
        Set<UUID> consumedMessages = consumedMessagesByConsumerGroup.computeIfAbsent("poc-consumer-group-2", k -> new HashSet<>());
        if (consumedMessages.contains(message.id())) {
            System.out.println("Message already consumed, skipping...");
            consumer.commitSync();
            return;
        }
        System.out.println("message = " + message);
        consumer.commitSync();
        consumedMessages.add(message.id());
    }

}
