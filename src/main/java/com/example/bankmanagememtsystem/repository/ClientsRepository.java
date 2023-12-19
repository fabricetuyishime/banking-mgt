package com.example.bankmanagememtsystem.repository;

import com.example.bankmanagememtsystem.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients,UUID> {
}
