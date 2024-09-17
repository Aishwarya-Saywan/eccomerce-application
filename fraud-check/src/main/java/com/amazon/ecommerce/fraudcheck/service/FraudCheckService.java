package com.amazon.ecommerce.fraudcheck.service;

import com.amazon.ecommerce.fraudcheck.entity.FraudCheckHistory;
import com.amazon.ecommerce.fraudcheck.repository.FraudCheckRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Slf4j
@Service
public record FraudCheckService(FraudCheckRepository fraudCheckRepository) {

    public Boolean checkIfFraudulent(String customerId, String email) {
        log.info("checking if the customer is fraudulent");
        fraudCheckRepository.save(FraudCheckHistory.builder()
                .customerId(Integer.parseInt(customerId))
                .email(email)
                .isFraudulent(false)
                .timestamp(LocalDateTime.now())
                .build());
        log.info("customer is not fraudulent");
        return false;
    }
}
