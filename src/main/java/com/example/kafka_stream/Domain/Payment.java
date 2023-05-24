package com.example.kafka_stream.Domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Payment {
    private String name;
    private double amount;
}
