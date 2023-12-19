package com.example.bankmanagememtsystem.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clients {
    @Id
    @GeneratedValue
    private UUID id;
    private String nationalId;
    private String fullName;
    private LocalDate dateOfBirth;
    private String email;
    private String phoneNumber;
//    private BigDecimal balance;
//
//    @PrePersist
//   @PreUpdate
//    public void setDefaultValues() {
//        if (balance == null) {
//            balance = BigDecimal.valueOf(0);
//        }
//    }

}
