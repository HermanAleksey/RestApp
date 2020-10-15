package org.bsuir.lab.controller;

import org.bsuir.lab.repository.MessageRepository;
import org.bsuir.lab.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
}
