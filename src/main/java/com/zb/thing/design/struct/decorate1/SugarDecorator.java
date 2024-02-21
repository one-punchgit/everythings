package com.zb.thing.design.struct.decorate1;

public class SugarDecorator implements CoffeeDecorator{
    private Coffee coffee;

    public SugarDecorator(Coffee coffee){
        this.coffee = coffee;
    }
    @Override
    public String getDescription() {
        return this.coffee.getDescription() + ",sugar";
    }

    @Override
    public double getCost() {
        return this.coffee.getCost() + 3.0;
    }
}
