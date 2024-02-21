package com.zb.thing.design.struct.decorate1;

public class SampleCoffee implements Coffee{
    @Override
    public String getDescription() {
        return "sample coffee";
    }

    @Override
    public double getCost() {
        return 1.0;
    }
}
