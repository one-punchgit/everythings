package com.zb.thing.design.behavioral.observer;

public class Admin implements ProductObserver{
    public void onPublished(Product p){
        System.out.println("admin 收到 产品发布" + p.getName() +","+ p.getPrice());
    }

    public void onPriceChanged(Product p){
        System.out.println("admin 收到 产品变动" + p.getName() +","+ p.getPrice());
    }
}
