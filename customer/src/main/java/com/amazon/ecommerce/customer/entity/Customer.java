package com.amazon.ecommerce.customer.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Customer {
    @GeneratedValue
    @Id
    private Integer customerId;
    private String firstname;
    private String lastname;
    private String email;
}
