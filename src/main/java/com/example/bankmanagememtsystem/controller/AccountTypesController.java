package com.example.bankmanagememtsystem.controller;

import com.example.bankmanagememtsystem.model.AccountTypes;
import com.example.bankmanagememtsystem.service.interfaces.AccountTypesInterface;
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
public class AccountTypesController {
    @Autowired
    private AccountTypesInterface service;

    @GetMapping("/accountTypes")
    public String viewHome( Model model) {
        AccountTypes accountTypes = new AccountTypes();
        List<AccountTypes> listAccountTypes = service.getAllAccountTypes();
        model.addAttribute("accountTypes",accountTypes);
        model.addAttribute("listAccountTypes", listAccountTypes);
        String text = "Save";
        model.addAttribute("text", text);
        return "accountTypes";
    }

    @PostMapping("/saveAccountTypes")
    public String saveAccountTypesUnit(@ModelAttribute("accountTypes") AccountTypes accountTypes) {
        service.saveAccountTypes(accountTypes);
        return "redirect:/accountTypes";
    }
    @GetMapping("/showFormForUpdateAccountTypes/{id}")
    public String showFormForUpdate(@PathVariable(value = "id") UUID id, Model model) {
        Optional<AccountTypes> accountTypes = service.getAccountTypesById(id);
        model.addAttribute("accountTypes", accountTypes);
        List<AccountTypes> listAccountTypes = service.getAllAccountTypes();
        model.addAttribute("listAccountTypes", listAccountTypes);
        String text = "Update";
        model.addAttribute("text", text);
        return "accountTypes";
    }
    @GetMapping("/deleteAccountTypes/{id}")
    public String deleteAccountTypesUnit(@PathVariable (value="id") UUID id) {
        this.service.deleteAccountTypesById(id);
        return "redirect:/accountTypes";
    }

}
