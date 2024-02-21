package com.zb.thing.design.behavioral.observer;

public interface ProductObserver {
    void onPublished(Product p);
    void onPriceChanged(Product p);
}
