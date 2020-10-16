package org.bsuir.lab.controller;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class AccountController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("/account")
    public String greeting(Map<String, Object> model) {
        return "account";
    }

    @PostMapping("/account/create")
    public String create(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String role,
            Map<String, Object> model) {
        if (!login.isEmpty() || !password.isEmpty() || !role.isEmpty()) {
            Account account = new Account(login, password, role);
            accountRepository.save(account);
        }

        return "account";
    }

    TODO("Make this field accepting only ints");
    @PostMapping("/account/selectById")
    public String selectById(
            @RequestParam int id,
            Map<String, Object> model) {

        Iterable<Account> accounts = accountRepository.findAccountById(id);
        model.put("accounts", accounts);

        return "account";
    }

    @PostMapping("/account/selectByLogin")
    public String selectByLogin(
            @RequestParam String login,
            Map<String, Object> model) {
        if (login.isEmpty()) {
            Iterable<Account> accounts = accountRepository.findByLogin(login);
            model.put("accounts", accounts);
        }

        return "account";
    }

    @PostMapping("/account/selectByPassword")
    public String selectByPassword(
            @RequestParam String password,
            Map<String, Object> model) {
        if (password.isEmpty()) {
            Iterable<Account> accounts = accountRepository.findByPassword(password);
            model.put("accounts", accounts);
        }

        return "account";
    }

    @PostMapping("/account/selectByRole")
    public String selectByRole(
            @RequestParam String role,
            Map<String, Object> model) {

        Iterable<Account> accounts = accountRepository.findByRole(role);
        model.put("accounts", accounts);

        if (role.isEmpty()) {
            accounts = accountRepository.findAll();
            model.put("accounts", accounts);
        }

        return "account";
    }

    @PostMapping("/account/update")
    public String update(
            @RequestParam int id,
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String role,
            Map<String, Object> model) {
        if (!login.isEmpty() || !password.isEmpty() || !role.isEmpty()) {
            Account account = new Account(id, login, password, role);
            accountRepository.save(account);
        }
        return "account";
    }

    @PostMapping("/account/delete")
    public String delete(
            @RequestParam int id,
            Map<String, Object> model) {
        accountRepository.deleteAccountById(id);
        return "account";
    }

}
