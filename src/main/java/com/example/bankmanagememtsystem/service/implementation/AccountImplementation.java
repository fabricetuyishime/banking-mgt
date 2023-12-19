package com.example.bankmanagememtsystem.service.implementation;

import com.example.bankmanagememtsystem.model.Account;
import com.example.bankmanagememtsystem.repository.AccountRepository;
import com.example.bankmanagememtsystem.service.interfaces.AccountInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountImplementation implements AccountInterface {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public void saveAccount(Account account) {
        this.accountRepository.save(account);
    }

    @Override
    public Optional<Account> getAccountById(String id) {
        return accountRepository.findById(id);
    }

    @Override
    public void deleteAccountById(String id) {
        this.accountRepository.deleteById(id);
    }

    @Override
    public Optional<Account> getAccountByNumber(String accNum) {
        return Optional.ofNullable(accountRepository.findAccountByAccountNumber(accNum));
    }

}