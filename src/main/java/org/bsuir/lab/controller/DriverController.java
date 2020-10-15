package org.bsuir.lab.controller;

import org.bsuir.lab.repository.DriverRepository;
import org.bsuir.lab.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;
}
