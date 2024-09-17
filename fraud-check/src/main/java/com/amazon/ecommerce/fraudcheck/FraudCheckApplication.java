package com.amazon.ecommerce.fraudcheck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FraudCheckApplication {
    public static void main(String[] args) {
        SpringApplication.run(FraudCheckApplication.class, args);
    }
}
