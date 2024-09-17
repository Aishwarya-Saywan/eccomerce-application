package com.amazon.ecommerce.fraudcheck.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class FraudCheckHistory {
    @GeneratedValue
    @Id
    private Integer id;
    private Integer customerId;
    private String email;
    private Boolean isFraudulent;
    private LocalDateTime timestamp;
}
