package com.tshape.ims.model;

import javax.persistence.*;

@Entity
@Table(name="Item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double cost;

    public Item(){
    }

    public Item(String name, double cost){
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
}
