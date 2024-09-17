package com.amazon.ecommerce.customer.repository;

import com.amazon.ecommerce.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
