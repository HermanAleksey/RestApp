package org.bsuir.lab.domain;

import javax.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String article;
    private String title;
    private int amount;
    @OneToOne
    @JoinColumn(name = "waybill_id")
    private Waybill waybill;

    public Product() {
    }

    public Product(String article, String title, int amount, Waybill waybill) {
        this.article = article;
        this.title = title;
        this.amount = amount;
        this.waybill = waybill;
    }

    public int getId() {
        return id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Waybill getWaybill() {
        return waybill;
    }

    public void setWaybill(Waybill waybill) {
        this.waybill = waybill;
    }
}
