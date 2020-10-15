package org.bsuir.lab.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class LogisticsCenter {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String name;
    private String location;
    @ManyToMany
    @JoinTable(name = "logistics_center_product",
            joinColumns = {@JoinColumn(name = "logistics_center_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id", referencedColumnName = "id")})
    private List<Product> product;

    public LogisticsCenter() {
    }

    public LogisticsCenter(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
