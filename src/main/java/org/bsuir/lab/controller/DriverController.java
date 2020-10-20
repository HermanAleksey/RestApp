package org.bsuir.lab.controller;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.repository.DriverRepository;
import org.bsuir.lab.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class DriverController {
    @Autowired
    private DriverRepository driverRepository;

    @GetMapping("/driver")
    public String greeting(Map<String, Object> model) {
        return "driver";
    }

    @PostMapping("/driver/create")
    public String create(
            @RequestParam String fio,
            @RequestParam String phoneNumber,
            Map<String, Object> model) {
        if (!fio.isEmpty() || !phoneNumber.isEmpty()) {
            Driver driver = new Driver(fio, phoneNumber);
            driverRepository.save(driver);
        }
        return "driver";
    }

    @PostMapping("/driver/selectById")
    public String selectById(
            @RequestParam int id,
            Map<String, Object> model) {

        Iterable<Driver> drivers = driverRepository.findDriverById(id);
        model.put("drivers", drivers);

        return "driver";
    }

    @PostMapping("/driver/selectByFIO")
    public String selectByFIO(
            @RequestParam String fio,
            Map<String, Object> model) {
        Iterable<Driver> drivers = driverRepository.findDriverByFio(fio);
        model.put("drivers", drivers);

        if (fio.isEmpty()) {
            drivers = driverRepository.findAll();
            model.put("drivers", drivers);
        }
        return "driver";
    }

    @PostMapping("/driver/selectByPhoneNumber")
    public String selectByPassword(
            @RequestParam String phoneNumber,
            Map<String, Object> model) {
        Iterable<Driver> drivers = driverRepository.findDriverByPhoneNumber(phoneNumber);
        model.put("drivers", drivers);

        if (phoneNumber.isEmpty()) {
            drivers = driverRepository.findAll();
            model.put("drivers", drivers);
        }

        return "driver";
    }

    @PostMapping("/driver/update")
    public String update(
            @RequestParam int id,
            @RequestParam String fio,
            @RequestParam String phoneNumber,
            Map<String, Object> model) {
        if (!fio.isEmpty() || !phoneNumber.isEmpty()) {
            Driver driver = new Driver(id, fio, phoneNumber);
            driverRepository.save(driver);
        }
        return "driver";
    }

    @PostMapping("/driver/delete")
    public String delete(
            @RequestParam int id,
            Map<String, Object> model) {
        driverRepository.deleteDriverById(id);
        return "driver";
    }
}
