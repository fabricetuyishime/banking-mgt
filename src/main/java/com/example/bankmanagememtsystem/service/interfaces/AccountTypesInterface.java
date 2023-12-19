package com.example.bankmanagememtsystem.service.interfaces;

import com.example.bankmanagememtsystem.model.AccountTypes;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountTypesInterface {

    List<AccountTypes> getAllAccountTypes();
    void saveAccountTypes(AccountTypes accountTypes);
    Optional<AccountTypes> getAccountTypesById(UUID id);
    void deleteAccountTypesById(UUID id);
}
