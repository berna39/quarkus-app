package com.terminator.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Table(name="product")
public class Product extends PanacheEntity{

    private String name;
    private Double price;

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Double getPrice(){
        return this.price;
    }

    public void setPrice(Double price){
        this.price = price;
    }
}
