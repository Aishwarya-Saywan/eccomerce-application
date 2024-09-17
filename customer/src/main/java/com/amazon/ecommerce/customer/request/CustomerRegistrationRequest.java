package com.amazon.ecommerce.customer.request;

public record CustomerRegistrationRequest(
        String firstname,
        String lastname,
        String email
) {
}
