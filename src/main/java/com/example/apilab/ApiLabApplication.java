package com.example.apilab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.io.IOException;

@EnableFeignClients
@SpringBootApplication
public class ApiLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiLabApplication.class, args);
    }

}
