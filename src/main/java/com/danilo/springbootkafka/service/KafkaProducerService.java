package com.danilo.springbootkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate<String,String> template;

    @Value("${spring.kafka.topic}")
    private String topic;

    public void sendMessage(String message) {
        this.template.send(this.topic,message);
    }

}
