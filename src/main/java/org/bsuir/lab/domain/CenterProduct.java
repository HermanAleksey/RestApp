//package org.bsuir.lab.domain;
//
//import javax.persistence.*;
//
//@Entity
//public class CenterProduct {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private int id;
//    @ManyToOne
//    @JoinColumn(name = "logistics_center_id")
//    private LogisticsCenter logisticsCenter;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    public CenterProduct() {
//    }
//
//    public CenterProduct(LogisticsCenter logisticsCenter, Product product) {
//        this.logisticsCenter = logisticsCenter;
//        this.product = product;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public LogisticsCenter getLogisticsCenter() {
//        return logisticsCenter;
//    }
//
//    public void setLogisticsCenter(LogisticsCenter logisticsCenter) {
//        this.logisticsCenter = logisticsCenter;
//    }
//
//    public Product getProduct() {
//        return product;
//    }
//
//    public void setProduct(Product product) {
//        this.product = product;
//    }
//}
