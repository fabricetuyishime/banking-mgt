package com.example.bankmanagememtsystem.controller;

import com.example.bankmanagememtsystem.model.Account;
import com.example.bankmanagememtsystem.model.AccountTypes;
import com.example.bankmanagememtsystem.model.Clients;
import com.example.bankmanagememtsystem.model.Transaction;
import com.example.bankmanagememtsystem.service.interfaces.AccountInterface;
import com.example.bankmanagememtsystem.service.interfaces.AccountTypesInterface;
import com.example.bankmanagememtsystem.service.interfaces.ClientsInterface;
import com.example.bankmanagememtsystem.service.interfaces.TransactionInterface;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Controller
public class DepositController {
    @Autowired
    private AccountInterface accountInterface;
    @Autowired
    private ClientsInterface clientsInterface;
    @Autowired
    private AccountTypesInterface accountTypesInterface;
    @Autowired
    private TransactionInterface transactionInterface;


    @GetMapping("/findAccount")
    public String findDeposit(Model model){
        Account account = new Account();
        Transaction transaction = new Transaction();
        model.addAttribute("account",account);
        model.addAttribute("transaction", transaction);
        return"deposit";

    }@GetMapping("/deposit")
    public String CarryDeposit(@RequestParam("accNum") String accNum, Model model){
        Optional<Account> account= accountInterface.getAccountById(accNum);
        Optional<Transaction> transaction = transactionInterface.getAccountNumber(accNum);
        System.out.println(accNum);
        System.out.println(transaction);
        model.addAttribute("account",account);
        model.addAttribute("transaction", transaction);

        return"deposit";
    }

    @PostMapping("/completeDeposit")
    public String saveClientsUnit(@RequestParam(value = "amount") BigDecimal amount,
                                  @RequestParam(value = "accNum1") String accNum,
                                  @ModelAttribute("transaction") Transaction transaction) {
        accNum = "BK96242";
        Account account = new Account();
        Optional<Account> foundAccount = accountInterface.getAccountById(accNum);
        BigDecimal balance = foundAccount.get().getBalance();
        // Update the account balance by adding the transaction amount
        BigDecimal newBalance = account.getBalance().add(transaction.getAmount());
        account.setBalance(newBalance);
        transaction.setAccount(account);
        // Save the updated account
        accountInterface.saveAccount(account);
        transaction.setAmount(amount);
        transactionInterface.saveTransaction(transaction);
        return "redirect:/transaction";
    }

    @PostMapping("/updateBalance")
    public String updateBalance(Model model){

        return "redirect:/account";
    }
}
