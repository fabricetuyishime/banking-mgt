package com.example.bankmanagememtsystem.service.implementation;

import com.example.bankmanagememtsystem.model.Transaction;
import com.example.bankmanagememtsystem.repository.TransactionRepository;
import com.example.bankmanagememtsystem.service.interfaces.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionImplementation implements TransactionInterface {
    @Autowired
    private TransactionRepository transactionRepository;
    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        this.transactionRepository.save(transaction);
    }

    @Override
    public Optional<Transaction> getTransactionById(UUID id) {
        return transactionRepository.findById(id);
    }

    @Override
    public void deleteTransactionById(UUID id) {
        this.transactionRepository.deleteById(id);
    }

    @Override
    public Optional<Transaction> getAccountNumber(String accountNUmber) {
        return Optional.ofNullable(transactionRepository.findTransactionByAccount_AccountNumber(accountNUmber));
    }
}
