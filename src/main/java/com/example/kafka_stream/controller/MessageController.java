package com.example.kafka_stream.controller;

import com.example.kafka_stream.Domain.Payment;
import com.example.kafka_stream.core.KafkaProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class MessageController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public MessageController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/messages")
    public void sendMessageToKafka(@RequestBody Payment payment) throws JsonProcessingException {
        kafkaProducer.sendMessage(payment);
    }
}