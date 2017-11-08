package com.rubenjg.vm.messaging;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class Messaging {

    public static void main(String[] args) {
        SpringApplication.run(Messaging.class, args);
    }
}
