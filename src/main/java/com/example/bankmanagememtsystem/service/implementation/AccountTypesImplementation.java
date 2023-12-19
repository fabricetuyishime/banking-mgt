package com.example.bankmanagememtsystem.service.implementation;

import com.example.bankmanagememtsystem.model.AccountTypes;
import com.example.bankmanagememtsystem.repository.AccountTypesRepository;
import com.example.bankmanagememtsystem.service.interfaces.AccountTypesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AccountTypesImplementation implements AccountTypesInterface {

    @Autowired
    private AccountTypesRepository accountTypesRepository;
    @Override
    public List<AccountTypes> getAllAccountTypes() {
        return accountTypesRepository.findAll();
    }

    @Override
    public void saveAccountTypes(AccountTypes accountTypes) {
        this.accountTypesRepository.save(accountTypes);
    }

    @Override
    public Optional<AccountTypes> getAccountTypesById(UUID id) {
        return accountTypesRepository.findById(id);
    }

    @Override
    public void deleteAccountTypesById(UUID id) {
        this.accountTypesRepository.deleteById(id);
    }
}
