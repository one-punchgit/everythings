package com.zb.thing.design.struct.decorate;

public class Fish extends Change {
    public Fish(TheGreatestSageInterface sage) {
        super(sage);
    }
    
    @Override
    public void move() {
        super.move();
        System.out.println("Change fish move");
    }
}