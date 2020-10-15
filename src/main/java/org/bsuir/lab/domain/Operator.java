package org.bsuir.lab.domain;

import javax.persistence.*;

@Entity
public class Operator {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fio;
    private String phoneNumber;
    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Operator() {
    }

    public Operator(String fio, String phoneNumber, Account account) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
