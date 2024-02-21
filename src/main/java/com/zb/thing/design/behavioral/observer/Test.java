package com.zb.thing.design.behavioral.observer;

public class Test {
    public static void main(String[] args) {

        Store store = new Store();

        Product xyj = new Product("西游记", (double) 13);

//        store.addNewProduct(xyj.getName(),xyj.getPrice());
        Admin admin1 = new Admin();
        Admin admin2 = new Admin();
        store.addObserver(admin1);
        store.addObserver(admin2);

        store.addNewProduct(xyj.getName(),xyj.getPrice());

        store.removeObserver(admin1);

        store.setProductPrice("西游记",15.0);
    }
}
