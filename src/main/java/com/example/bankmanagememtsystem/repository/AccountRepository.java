package com.example.bankmanagememtsystem.repository;

import com.example.bankmanagememtsystem.model.Account;
import com.example.bankmanagememtsystem.model.Transaction;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, String> {
    Account findAccountByAccountNumber(String accountNumber);
}
