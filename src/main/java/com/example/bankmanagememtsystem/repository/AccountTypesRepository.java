package com.example.bankmanagememtsystem.repository;

import com.example.bankmanagememtsystem.model.AccountTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountTypesRepository extends JpaRepository<AccountTypes, UUID> {
}
