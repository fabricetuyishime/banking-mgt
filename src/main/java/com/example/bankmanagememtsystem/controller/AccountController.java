package com.example.bankmanagememtsystem.controller;

import com.example.bankmanagememtsystem.model.Account;
import com.example.bankmanagememtsystem.model.AccountTypes;
import com.example.bankmanagememtsystem.model.Clients;
import com.example.bankmanagememtsystem.service.interfaces.AccountInterface;
import com.example.bankmanagememtsystem.service.interfaces.AccountTypesInterface;
import com.example.bankmanagememtsystem.service.interfaces.ClientsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Controller
public class AccountController {
    @Autowired
    private AccountInterface service;
    @Autowired
    private ClientsInterface clientsInterface;
    @Autowired
    private AccountTypesInterface accountTypesInterface;
    

    @GetMapping("/account")
    public String viewHome(@ModelAttribute("account") Account account, Model model) {
        List<Account> listAccount = service.getAllAccounts();
        model.addAttribute("listAccount", listAccount);
        String text = "Save";
        model.addAttribute("text", text);
        Random random = new Random();
        int genNumber = random.nextInt(10000,99999);
        String accountNumber= "BK"+genNumber;
        model.addAttribute("genAccountNumber",accountNumber);
        List<Clients> clientsList = clientsInterface.getAllClients();
        model.addAttribute("clientsList",clientsList);
        List<AccountTypes> accountTypesList = accountTypesInterface.getAllAccountTypes();
        model.addAttribute("accountTypesList",accountTypesList);
        return "account";
    }

    @PostMapping("/saveAccount")
    public String saveAccountUnit(@ModelAttribute("account") Account account, @RequestParam(value = "accountNum") String accountNum) {
        account.setAccountNumber(accountNum);
        service.saveAccount(account);
        return "redirect:/account";
    }
    @GetMapping("/showFormForUpdateAccount/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") String id, Model model) {
        Optional<Account> account = service.getAccountById(id);
        model.addAttribute("account", account);
        List<Account> listAccount = service.getAllAccounts();
        model.addAttribute("listAccount", listAccount);
        String text = "Update";
        model.addAttribute("text", text);
        List<Clients> clientsList = clientsInterface.getAllClients();
        model.addAttribute("clientsList",clientsList);
        List<AccountTypes> accountTypesList = accountTypesInterface.getAllAccountTypes();
        model.addAttribute("accountTypesList",accountTypesList);
        return "account";
    }
    @GetMapping("/deleteAccount/{id}")
    public String deleteAccountUnit(@PathVariable (value="id") String id) {
        this.service.deleteAccountById(id);
        return "redirect:/account";
    }

}
