package com.rubenjg.pu.counter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Counter {

    public static void main(String[] args) {
        SpringApplication.run(Counter.class, args);
    }
}
