package com.example.bankmanagememtsystem.service.interfaces;

import com.example.bankmanagememtsystem.model.Transaction;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionInterface {

    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    Optional<Transaction> getTransactionById(UUID id);
    void deleteTransactionById(UUID id);
    Optional<Transaction> getAccountNumber(String accountNUmber);
}
