package com.danilo.springbootkafka.controller;

import com.danilo.springbootkafka.domain.Order;
import com.danilo.springbootkafka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody Order order) {
        this.service.insert(order);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
