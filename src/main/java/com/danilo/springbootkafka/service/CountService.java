package com.danilo.springbootkafka.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class CountService {

    private Integer count = 0;

    @Scheduled(fixedRate = 1000)
    public void increment() {
        this.count++;
    }

    public Integer getCount() {
        return this.count;
    }

}
