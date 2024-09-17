package com.amazon.ecommerce.fraudcheck.repository;

import com.amazon.ecommerce.fraudcheck.entity.FraudCheckHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FraudCheckRepository extends JpaRepository<FraudCheckHistory, Integer> {
}
