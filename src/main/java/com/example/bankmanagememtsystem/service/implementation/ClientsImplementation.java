package com.example.bankmanagememtsystem.service.implementation;

import com.example.bankmanagememtsystem.model.Clients;
import com.example.bankmanagememtsystem.repository.ClientsRepository;
import com.example.bankmanagememtsystem.service.interfaces.ClientsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Service
public class ClientsImplementation implements ClientsInterface {

    @Autowired
    private ClientsRepository clientsRepository;
    @Override
    public List<Clients> getAllClients() {
        return clientsRepository.findAll();
    }

    @Override
    public void saveClients(Clients clients) {
        this.clientsRepository.save(clients);
    }

    @Override
    public Optional<Clients> getClientsById(UUID id) {
        return clientsRepository.findById(id);
    }

    @Override
    public void deleteClientsById(UUID id) {
        this.clientsRepository.deleteById(id);
    }
}
