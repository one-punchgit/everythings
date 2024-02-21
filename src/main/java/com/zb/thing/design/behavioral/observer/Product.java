package com.zb.thing.design.behavioral.observer;

import lombok.Data;

@Data
public class Product {
    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }
    private String name;
    private double price;
}
