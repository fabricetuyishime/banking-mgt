package com.example.bankmanagememtsystem.controller;

import com.example.bankmanagememtsystem.model.Clients;
import com.example.bankmanagememtsystem.service.interfaces.ClientsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ClientsController {
    @Autowired
    private ClientsInterface service;

    @GetMapping("/clients")
    public String viewHome( Model model) {
        Clients clients = new Clients();
        List<Clients> listClients = service.getAllClients();
        model.addAttribute("clients",clients);
        model.addAttribute("listClients", listClients);
        String text = "Save";
        model.addAttribute("text", text);
        return "clients";
    }

    @PostMapping("/saveClients")
    public String saveClientsUnit(@ModelAttribute("clients") Clients clients) {
        service.saveClients(clients);
        return "redirect:/clients";
    }
    @GetMapping("/showFormForUpdateClients/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        Optional<Clients> clients = service.getClientsById(id);
        model.addAttribute("clients", clients);
        List<Clients> listClients = service.getAllClients();
        model.addAttribute("listClients", listClients);
        String text = "Update";
        model.addAttribute("text", text);
        return "clients";
    }
    @GetMapping("/deleteClients/{id}")
    public String deleteClientsUnit(@PathVariable (value="id") UUID id) {
        this.service.deleteClientsById(id);
        return "redirect:/clients";
    }

}
