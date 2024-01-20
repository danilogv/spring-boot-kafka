package com.danilo.springbootkafka.controller;

import com.danilo.springbootkafka.service.CountService;
import com.danilo.springbootkafka.service.KafkaConsumerService;
import com.danilo.springbootkafka.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    @Autowired
    private KafkaConsumerService consumerService;

    @Autowired
    private KafkaProducerService producerService;

    @Autowired
    private CountService countService;

    @GetMapping
    public ResponseEntity<Void> count() {
        Integer count = this.countService.getCount();
        this.producerService.sendMessage(String.valueOf(count));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
