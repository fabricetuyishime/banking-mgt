package com.example.bankmanagememtsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class AccountTypes {
    @Id
    @GeneratedValue
    private UUID id;
    private String accountTypeName;
    private Integer interestRate;
}

