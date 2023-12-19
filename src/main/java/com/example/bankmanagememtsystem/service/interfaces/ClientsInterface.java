package com.example.bankmanagememtsystem.service.interfaces;

import com.example.bankmanagememtsystem.model.Clients;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ClientsInterface {

    List<Clients> getAllClients();
    void saveClients(Clients clients);
    Optional<Clients> getClientsById(UUID id);
    void deleteClientsById(UUID id);
}
