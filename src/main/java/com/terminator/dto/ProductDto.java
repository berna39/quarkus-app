package com.terminator.dto;

public class ProductDto {
    
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
