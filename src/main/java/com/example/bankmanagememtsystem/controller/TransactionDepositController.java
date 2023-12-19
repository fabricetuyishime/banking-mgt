package com.example.bankmanagememtsystem.controller;

import com.example.bankmanagememtsystem.model.Account;
import com.example.bankmanagememtsystem.model.Transaction;
import com.example.bankmanagememtsystem.service.interfaces.AccountInterface;
import com.example.bankmanagememtsystem.service.interfaces.AccountTypesInterface;
import com.example.bankmanagememtsystem.service.interfaces.ClientsInterface;
import com.example.bankmanagememtsystem.service.interfaces.TransactionInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class TransactionDepositController {
    @Autowired
    private AccountInterface accountInterface;
    @Autowired
    private ClientsInterface clientsInterface;
    @Autowired
    private AccountTypesInterface accountTypesInterface;
    @Autowired
    private TransactionInterface transactionInterface;


    @GetMapping("/findAccounts")
    public String findDeposit(Model model){
        Transaction transaction = new Transaction();
        model.addAttribute("transaction", transaction);
        return"deposits";

    }@GetMapping("/deposits")
    public String CarryDeposit(@RequestParam("accNum") String accNum, Model model){
        Optional<Transaction> account = transactionInterface.getAccountNumber(accNum);
        Transaction transaction = new Transaction();
        model.addAttribute("account",account);
        model.addAttribute("transaction", transaction);

        return"deposits";
    }

    @PostMapping("/completeDeposits")
    public String saveClientsUnit(@ModelAttribute("transaction") Transaction transaction) {
//        BigDecimal balance = transaction.getAccount().getBalance();
        transactionInterface.saveTransaction(transaction);
        return "redirect:/transaction";
    }
    @PostMapping("/updateBalances")
    public String updateBalance(Model model){

        return "redirect:/account";
    }
}
