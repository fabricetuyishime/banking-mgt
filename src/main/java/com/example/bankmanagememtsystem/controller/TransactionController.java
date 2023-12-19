package com.example.bankmanagememtsystem.controller;

import com.example.bankmanagememtsystem.model.Account;
import com.example.bankmanagememtsystem.model.Transaction;
import com.example.bankmanagememtsystem.service.interfaces.AccountInterface;
import com.example.bankmanagememtsystem.service.interfaces.TransactionInterface;
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
public class TransactionController {
    @Autowired
    private TransactionInterface service;
    @Autowired
    private AccountInterface accountInterface;
    

    @GetMapping("/transaction")
    public String viewHome(@ModelAttribute("transaction") Transaction transaction, Model model) {
        List<Transaction> listTransaction = service.getAllTransactions();
        model.addAttribute("listTransaction", listTransaction);
        String text = "Save";
        model.addAttribute("text", text);
        return "transaction";
    }

    @PostMapping("/saveTransaction")
    public String saveTransactionUnit(@PathVariable(value = "accNum") String id,@ModelAttribute("transaction") Transaction transaction, Model model) {
        Optional<Account> account = accountInterface.getAccountById(id);
//        accountInterface.saveAccount(account);
        transaction.setAccount(accountInterface.getAccountById(id).get());
        service.saveTransaction(transaction);
        return "redirect:/transaction";
    }
    @GetMapping("/showFormForUpdateTransaction/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        Optional<Transaction> transaction = service.getTransactionById(id);
        model.addAttribute("transaction", transaction);
        List<Transaction> listTransaction = service.getAllTransactions();
        model.addAttribute("listTransaction", listTransaction);
        String text = "Update";
        model.addAttribute("text", text);
        return "transaction";
    }
    @GetMapping("/deleteTransaction/{id}")
    public String deleteTransactionUnit(@PathVariable (value="id") UUID id) {
        this.service.deleteTransactionById(id);
        return "redirect:/transaction";
    }

}
