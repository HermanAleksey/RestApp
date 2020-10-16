package org.bsuir.lab.controller;

import org.bsuir.lab.repository.MessageRepository;
import org.bsuir.lab.repository.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class OperatorController {
    @Autowired
    private OperatorRepository operatorRepository;

    @GetMapping("/operator")
    public String greeting(Map<String, Object> model) {
        return "operator";
    }
}
