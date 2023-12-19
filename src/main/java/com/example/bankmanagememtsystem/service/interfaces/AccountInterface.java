package com.example.bankmanagememtsystem.service.interfaces;

import com.example.bankmanagememtsystem.model.Account;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountInterface {

    List<Account> getAllAccounts();
    void saveAccount(Account account);
    Optional<Account> getAccountById(String id);
    void deleteAccountById(String id);
    Optional<Account> getAccountByNumber(String accNum);
}
