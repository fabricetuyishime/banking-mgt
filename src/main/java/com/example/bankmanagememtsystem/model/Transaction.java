package com.example.bankmanagememtsystem.model;

import com.example.bankmanagememtsystem.model.enums.EType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue
    private UUID id;
    @ManyToOne
    private Account account;
    @CreationTimestamp
    private LocalDateTime timeOfTransaction;
    @Enumerated(EnumType.STRING)
    private EType eType;
    private BigDecimal amount;


}
