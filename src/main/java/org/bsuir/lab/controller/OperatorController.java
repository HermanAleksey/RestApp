package org.bsuir.lab.controller;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.domain.LogisticsCenter;
import org.bsuir.lab.domain.Operator;
import org.bsuir.lab.repository.AccountRepository;
import org.bsuir.lab.repository.MessageRepository;
import org.bsuir.lab.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class OperatorController {
    @Autowired
    private OperatorRepository operatorRepository;

    @GetMapping("/operator")
    public String greeting(Map<String, Object> model) {
        return "operator";
    }

    @PostMapping("/operator/create")
    public String create(
            @RequestParam String fio,
            @RequestParam String phoneNumber,
            @RequestParam int accountId,
            Map<String, Object> model) {
//        Account account = new AccountRepository().findAccountById(accountId);
        Operator operator = new Operator(fio, phoneNumber, new Account(accountId));
        operatorRepository.save(operator);

        return "operator";
    }

    @PostMapping("/operator/selectById")
    public String selectById(
            @RequestParam int id,
            Map<String, Object> model) {

        Iterable<Operator> operators = operatorRepository.findOperatorById(id);
        model.put("operators", operators);

        return "operator";
    }

    @PostMapping("/operator/selectByFio")
    public String selectByFio(
            @RequestParam String fio,
            Map<String, Object> model) {
        Iterable<Operator> operators = operatorRepository.findOperatorByFio(fio);
        model.put("operators", operators);
        if (fio.isEmpty()) {
            operators = operatorRepository.findAll();
            model.put("operators", operators);
        }

        return "operator";
    }

    @PostMapping("/operator/selectByPhoneNumber")
    public String selectByPhoneNumber(
            @RequestParam String phoneNumber,
            Map<String, Object> model) {
        Iterable<Operator> operators = operatorRepository.findOperatorByPhoneNumber(phoneNumber);
        model.put("operators", operators);

        if (phoneNumber.isEmpty()) {
            operators = operatorRepository.findAll();
            model.put("operators", operators);
        }

        return "operator";
    }

    @PostMapping("/operator/selectByAccountId")
    public String selectByAccountId(
            @RequestParam int accountId,
            Map<String, Object> model) {
        Iterable<Operator> operators = operatorRepository.findOperatorByAccount_Id(accountId);
        model.put("operators", operators);

        return "operator";
    }

    @PostMapping("/operator/update")
    public String update(
            @RequestParam int id,
            @RequestParam String fio,
            @RequestParam String phoneNumber,
            @RequestParam int accountId,
            Map<String, Object> model) {
        Operator operator = new Operator(id, fio, phoneNumber, new Account(accountId));
        operatorRepository.save(operator);

        return "operator";
    }

    @PostMapping("/operator/delete")
    public String delete(
            @RequestParam int id,
            Map<String, Object> model) {
        operatorRepository.deleteOperatorById(id);
        return "operator";
    }
}
