package com.amazon.ecommerce.client.fraudcheck;

import com.amazon.ecommerce.client.response.SuccessResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        value = "fraud-check-application",
        path = "api/v1/fraud-check"
)
public interface FraudCheckClient {

    @GetMapping(path = "")
    public SuccessResponse checkIfFraudulent(
            @RequestParam(name = "customer_id") String customerId,
            @RequestParam(name = "email") String email);
}
