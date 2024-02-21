package com.zb.thing.design.struct.decorate1;

public class MilkCoffee implements CoffeeDecorator{
    private Coffee coffee;

    public MilkCoffee(Coffee coffee){
        super();
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ",milk";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 2.0;
    }
}
