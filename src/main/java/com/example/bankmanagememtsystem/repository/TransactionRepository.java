package com.example.bankmanagememtsystem.repository;

import com.example.bankmanagememtsystem.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.bankmanagememtsystem.model.Transaction;

import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {

    Transaction findTransactionByAccount_AccountNumber(String accountNumber);
}
