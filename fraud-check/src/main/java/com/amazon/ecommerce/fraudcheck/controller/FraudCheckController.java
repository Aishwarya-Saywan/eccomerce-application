package com.amazon.ecommerce.fraudcheck.controller;

import com.amazon.ecommerce.client.response.SuccessResponse;
import com.amazon.ecommerce.fraudcheck.service.FraudCheckService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequestMapping(path = "api/v1/fraud-check")
@RestController
public record FraudCheckController(FraudCheckService fraudCheckService) {

    @GetMapping(path = "")
    public SuccessResponse checkIfFraudulent(
            @RequestParam(name = "customer_id") String customerId,
            @RequestParam(name = "email") String email) {

        Boolean isFraudulent = fraudCheckService.checkIfFraudulent(customerId, email);

        return SuccessResponse.builder()
                .message("Customer is not fraudulent")
                .status(HttpStatus.OK)
                .timestamp(LocalDateTime.now())
                .data(isFraudulent)
                .build();
    }
}
