package org.bsuir.lab.controller;

import org.bsuir.lab.domain.Account;
import org.bsuir.lab.domain.Driver;
import org.bsuir.lab.domain.Operator;
import org.bsuir.lab.domain.Waybill;
import org.bsuir.lab.repository.MessageRepository;
import org.bsuir.lab.repository.WaybillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class WaybillController {
    @Autowired
    private WaybillRepository waybillRepository;

    @GetMapping("/waybill")
    public String greeting(Map<String, Object> model) {
        return "waybill";
    }

    @PostMapping("/waybill/create")
    public String create(
            @RequestParam String dateOfDelivery,
            @RequestParam String dateOfShipment,
            @RequestParam int driverId,
            @RequestParam int operatorId,
            Map<String, Object> model) {
        Waybill object = new Waybill(dateOfDelivery, dateOfShipment,
                new Driver(driverId), new Operator(operatorId));
        waybillRepository.save(object);

        return "waybill";
    }

    @PostMapping("/waybill/selectById")
    public String selectById(
            @RequestParam int id,
            Map<String, Object> model) {

        Iterable<Waybill> objects = waybillRepository.findOperatorById(id);
        model.put("waybills", objects);

        return "waybill";
    }

    @PostMapping("/waybill/selectByDateOfDelivery")
    public String selectByDateOfDelivery(
            @RequestParam String dateOfDelivery,
            Map<String, Object> model) {
        Iterable<Waybill> objects = waybillRepository.findWaybillByDateOfDelivery(dateOfDelivery);
        model.put("waybills", objects);
        if (dateOfDelivery.isEmpty()) {
            objects = waybillRepository.findAll();
            model.put("waybills", objects);
        }
        return "waybill";
    }

    @PostMapping("/waybill/selectByDateOfShipment")
    public String selectByDateOfShipment(
            @RequestParam String dateOfShipment,
            Map<String, Object> model) {
        Iterable<Waybill> objects = waybillRepository.findWaybillByDateOfShipment(dateOfShipment);
        model.put("waybills", objects);

        if (dateOfShipment.isEmpty()) {
            objects = waybillRepository.findAll();
            model.put("waybills", objects);
        }

        return "waybill";
    }

    @PostMapping("/waybill/selectByOperatorId")
    public String selectByOperatorId(
            @RequestParam int operatorId,
            Map<String, Object> model) {
        Iterable<Waybill> objects = waybillRepository.findWaybillByOperatorId(operatorId);
        model.put("waybills", objects);

        return "waybill";
    }

    @PostMapping("/waybill/selectByDriverId")
    public String selectByDriverId(
            @RequestParam int driverId,
            Map<String, Object> model) {
        Iterable<Waybill> objects = waybillRepository.findWaybillByOperatorId(driverId);
        model.put("waybills", objects);

        return "waybill";
    }

    @PostMapping("/waybill/update")
    public String update(
            @RequestParam int id,
            @RequestParam String dateOfDelivery,
            @RequestParam String dateOfShipment,
            @RequestParam int driverId,
            @RequestParam int operatorId,
            Map<String, Object> model) {
        Waybill waybill = new Waybill(id, dateOfDelivery, dateOfShipment,
                new Driver(driverId), new Operator(operatorId));
        waybillRepository.save(waybill);

        return "waybill";
    }

    @PostMapping("/waybill/delete")
    public String delete(
            @RequestParam int id,
            Map<String, Object> model) {
        waybillRepository.deleteWaybillById(id);
        return "waybill";
    }
}
