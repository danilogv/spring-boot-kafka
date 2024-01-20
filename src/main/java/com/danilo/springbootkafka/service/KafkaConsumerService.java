package com.danilo.springbootkafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    @KafkaListener(topics = {"counter"},groupId = "test-consumer-group")
    public void consumeMessage(String message) {
        System.out.println("Count : " + message);
    }

}
