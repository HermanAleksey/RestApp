package org.bsuir.lab.controller;

import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.Operator;
import org.bsuir.lab.domain.Product;
import org.bsuir.lab.domain.Waybill;
import org.bsuir.lab.repository.MessageRepository;
import org.bsuir.lab.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product")
    public String greeting(Map<String, Object> model) {
        return "product";
    }

    @PostMapping("/product/create")
    public String create(
            @RequestParam String article,
            @RequestParam String title,
            @RequestParam int amount,
            @RequestParam int waybillId,
            Map<String, Object> model) {
        Product object = new Product(article, title, amount, new Waybill(waybillId));
        productRepository.save(object);

        return "product";
    }

    @PostMapping("/product/selectById")
    public String selectById(
            @RequestParam int id,
            Map<String, Object> model) {
        Iterable<Product> objects = productRepository.findProductById(id);
        model.put("products", objects);

        return "product";
    }

    @PostMapping("/product/selectByArticle")
    public String selectByArticle(
            @RequestParam String article,
            Map<String, Object> model) {
        Iterable<Product> objects = productRepository.findProductByArticle(article);
        model.put("products", objects);
        if (article.isEmpty()) {
            objects = productRepository.findAll();
            model.put("products", objects);
        }
        return "product";
    }

    @PostMapping("/product/selectByTitle")
    public String selectByTitle(
            @RequestParam String title,
            Map<String, Object> model) {
        Iterable<Product> objects = productRepository.findProductByTitle(title);
        model.put("products", objects);
        if (title.isEmpty()) {
            objects = productRepository.findAll();
            model.put("products", objects);
        }

        return "product";
    }

    @PostMapping("/product/selectByAmount")
    public String selectByAmount(
            @RequestParam int amount,
            Map<String, Object> model) {
        Iterable<Product> objects = productRepository.findProductByAmount(amount);
        model.put("products", objects);

        return "product";
    }

    @PostMapping("/product/selectByWaybillId")
    public String selectByWaybillId(
            @RequestParam int waybillId,
            Map<String, Object> model) {
        Iterable<Product> objects = productRepository.findProductByWaybillId(waybillId);
        model.put("products", objects);

        return "product";
    }

    @PostMapping("/product/update")
    public String update(
            @RequestParam int id,
            @RequestParam String article,
            @RequestParam String title,
            @RequestParam int amount,
            @RequestParam int waybillId,
            Map<String, Object> model) {
        Product object = new Product(id, article, title, amount, new Waybill(waybillId));
        productRepository.save(object);

        return "product";
    }

    @PostMapping("/product/delete")
    public String delete(
            @RequestParam int id,
            Map<String, Object> model) {
        productRepository.deleteProductById(id);
        return "product";
    }
}
