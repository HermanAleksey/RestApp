package org.bsuir.lab.controller;

import org.bsuir.lab.repository.LogisticsCenterRepository;
import org.bsuir.lab.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class LogisticsCenterController {
    @Autowired
    private LogisticsCenterRepository logisticsCenterRepository;

    @GetMapping("/logcenter")
    public String greeting(Map<String, Object> model) {
        return "logcenter";
    }
}
