package org.bsuir.lab.controller;

import org.bsuir.lab.repository.LogisticsCenterRepository;
import org.bsuir.lab.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class LogisticsCenterController {
    @Autowired
    private LogisticsCenterRepository logisticsCenterRepository;
}
