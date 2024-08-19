package com.sami.StackOverFlowBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class StackOverFlowBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(StackOverFlowBackendApplication.class, args);
    }

}
