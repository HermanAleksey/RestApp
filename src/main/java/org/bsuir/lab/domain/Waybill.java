package org.bsuir.lab.domain;

import javax.persistence.*;

@Entity
public class Waybill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String dateOfDelivery;
    private String dateOfShipment;
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @ManyToOne
    @JoinColumn(name = "operator_id")
    private Operator operator;

    public Waybill() {
    }

    public Waybill(int id) {
        this.id = id;
    }

    public Waybill(String dateOfDelivery, String dateOfShipment, Driver driver, Operator operator) {
        this.dateOfDelivery = dateOfDelivery;
        this.dateOfShipment = dateOfShipment;
        this.driver = driver;
        this.operator = operator;
    }

    public Waybill(int id, String dateOfDelivery, String dateOfShipment, Driver driver, Operator operator) {
        this.id = id;
        this.dateOfDelivery = dateOfDelivery;
        this.dateOfShipment = dateOfShipment;
        this.driver = driver;
        this.operator = operator;
    }

    @Override
    public String toString() {
        return "Waybill{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(String dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public String getDateOfShipment() {
        return dateOfShipment;
    }

    public void setDateOfShipment(String dateOfShipment) {
        this.dateOfShipment = dateOfShipment;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }
}
