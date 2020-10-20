package org.bsuir.lab.controller;

import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.LogisticsCenter;
import org.bsuir.lab.repository.DriverRepository;
import org.bsuir.lab.repository.LogisticsCenterRepository;
import org.bsuir.lab.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class LogisticsCenterController {
    @Autowired
    private LogisticsCenterRepository logisticsCenterRepository;

    @GetMapping("/logcenter")
    public String greeting(Map<String, Object> model) {
        return "logcenter";
    }

    @PostMapping("/logcenter/create")
    public String create(
            @RequestParam String location,
            @RequestParam String name,
            Map<String, Object> model) {
        if (!location.isEmpty() || !name.isEmpty()) {
            LogisticsCenter logisticsCenter = new LogisticsCenter(location, name);
            logisticsCenterRepository.save(logisticsCenter);
        }
        return "logcenter";
    }

    @PostMapping("/logcenter/selectById")
    public String selectById(
            @RequestParam int id,
            Map<String, Object> model) {

        Iterable<LogisticsCenter> logisticsCenters = logisticsCenterRepository.findLogisticsCenterById(id);
        model.put("logcenters", logisticsCenters);

        return "logcenter";
    }

    @PostMapping("/logcenter/selectByLocation")
    public String selectByLocation(
            @RequestParam String location,
            Map<String, Object> model) {
        Iterable<LogisticsCenter> logisticsCenters = logisticsCenterRepository.findLogisticsCenterByLocation(location);
        model.put("logcenters", logisticsCenters);

        if (location.isEmpty()) {
            logisticsCenters = logisticsCenterRepository.findAll();
            model.put("logcenters", logisticsCenters);
        }
        return "logcenter";
    }

    @PostMapping("/logcenter/selectByName")
    public String selectByName(
            @RequestParam String name,
            Map<String, Object> model) {
        Iterable<LogisticsCenter> logisticsCenters = logisticsCenterRepository.findLogisticsCenterByName(name);
        model.put("logcenters", logisticsCenters);

        if (name.isEmpty()) {
            logisticsCenters = logisticsCenterRepository.findAll();
            model.put("logcenters", logisticsCenters);
        }

        return "logcenter";
    }

    @PostMapping("/logcenter/update")
    public String update(
            @RequestParam int id,
            @RequestParam String location,
            @RequestParam String name,
            Map<String, Object> model) {
        if (!location.isEmpty() || !name.isEmpty()) {
            LogisticsCenter logisticsCenter = new LogisticsCenter(id, name, location);
            logisticsCenterRepository.save(logisticsCenter);
        }
        return "logcenter";
    }

    @PostMapping("/logcenter/delete")
    public String delete(
            @RequestParam int id,
            Map<String, Object> model) {
        logisticsCenterRepository.deleteLogisticsCenterById(id);
        return "logcenter";
    }
}
