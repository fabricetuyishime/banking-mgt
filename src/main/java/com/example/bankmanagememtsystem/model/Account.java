package com.example.bankmanagememtsystem.model;

import com.example.bankmanagememtsystem.model.enums.ECurrency;
import com.example.bankmanagememtsystem.service.interfaces.AccountInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    private String accountNumber;
    private String accountName;
    @ManyToOne
    private Clients clients;
    @ManyToOne
    private AccountTypes accountTypes;
    private BigDecimal balance;
    @Enumerated(EnumType.STRING)
    private ECurrency eCurrency;
    @PrePersist
    @PreUpdate
    public void setDefaultValues() {
        if (balance == null) {
            balance = BigDecimal.valueOf(0);
        }
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }


}
