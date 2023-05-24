package com.example.kafka_stream.core;

import com.example.kafka_stream.Domain.Payment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Payment payment) throws JsonProcessingException {
        ObjectMapper mymapper=new ObjectMapper();
        String jsonString = mymapper.writeValueAsString(payment);
        kafkaTemplate.send("my-topic", jsonString);
    }
}

