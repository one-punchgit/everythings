package com.zb.thing.design.struct.decorate1;

public class Test {
    public static void main(String[] args) {
        Coffee coffee = new SampleCoffee();
        MilkCoffee milkCoffee = new MilkCoffee(coffee);
        SugarDecorator sugarDecorator = new SugarDecorator(milkCoffee);

        System.out.println(coffee.getDescription() + "," + coffee.getCost());
        System.out.println(milkCoffee.getDescription() + "," + milkCoffee.getCost());
        System.out.println(sugarDecorator.getDescription() + "," + sugarDecorator.getCost());
    }
}
