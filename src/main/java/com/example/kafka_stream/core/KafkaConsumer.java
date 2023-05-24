package com.example.kafka_stream.core;

import com.example.kafka_stream.Domain.Payment;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "my-consumer-group")
    public void consumeMessage(Payment payment) {
        System.out.println("Received message: " + payment);
        // Process the message as needed
    }
}
