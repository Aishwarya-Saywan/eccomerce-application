package com.amazon.ecommerce.customer.service;

import com.amazon.ecommerce.client.fraudcheck.FraudCheckClient;
import com.amazon.ecommerce.client.response.SuccessResponse;
import com.amazon.ecommerce.customer.entity.Customer;
import com.amazon.ecommerce.customer.repository.CustomerRepository;
import com.amazon.ecommerce.customer.request.CustomerRegistrationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public record CustomerService(
        CustomerRepository customerRepository,
        RestTemplate restTemplate,
        FraudCheckClient fraudCheckClient
) {
    public Integer registerCustomer(CustomerRegistrationRequest request) {
        log.info("Trying to register customer");

        String email = request.email();
        String id = 1 + "";
//        SuccessResponse successResponse = restTemplate.getForObject(
//                "http://FRAUD-CHECK-APPLICATION/api/v1/fraud-check?customer_id={id}&email={email}",
//                SuccessResponse.class, id, email
//        );
        SuccessResponse successResponse = fraudCheckClient.checkIfFraudulent(id, email);
        if ((Boolean) successResponse.getData()) {
            throw new RuntimeException("Customer is fraudulent");
        }
        log.info("Customer is checked, not fraudulent, saving data...");
        return customerRepository.save(
                Customer.builder()
                        .firstname(request.firstname())
                        .lastname(request.lastname())
                        .email(request.email())
                        .build()
                ).getCustomerId();
    }
}
