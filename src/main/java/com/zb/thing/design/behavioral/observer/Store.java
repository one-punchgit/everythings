package com.zb.thing.design.behavioral.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
//    Customer customer = new Customer();
//    Admin admin =  new Admin();

    private Map<String, Product> products = new HashMap<>();

    private List<ProductObserver> productObservers = new ArrayList<>();

    public void addObserver(ProductObserver productObserver){
        this.productObservers.add(productObserver);
    }

    public void removeObserver(ProductObserver productObserver){
        this.productObservers.remove(productObserver);
    }
    public void addNewProduct(String name, double price) {
        Product p = new Product(name, price);
        products.put(p.getName(), p);
        // 通知用户:
        for (ProductObserver productObserver : productObservers) {
            productObserver.onPublished(p);
        }
    }

    public void setProductPrice(String name, double price) {
        Product p = products.get(name);
        p.setPrice(price);
        for (ProductObserver productObserver : productObservers) {
            productObserver.onPriceChanged(p);
        }
    }
}