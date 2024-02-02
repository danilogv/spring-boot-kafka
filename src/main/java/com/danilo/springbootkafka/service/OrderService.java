package com.danilo.springbootkafka.service;

import com.danilo.springbootkafka.domain.Order;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Log4j2
public class OrderService {

    @Autowired
    private KafkaTemplate<Long,Order> template;

    @Value("${spring.kafka.topic}")
    private String topic;

    public void insert(Order order) {
        order.setDateTime(LocalDateTime.now());
        this.template.send(this.topic,order.getId(),order);
    }

    @KafkaListener(topics = {"order"},groupId = "test-consumer-group")
    public void consumeMessage(ConsumerRecord<Long,Order> record) {
        //Salvar em uma base de dados
        log.info("Key : " + record.key());
        log.info("Header : " + record.headers());
        log.info("Partition : " + record.partition());
        log.info("Topic : " + record.topic());
        log.info("Data :" + record.value());
    }

}
