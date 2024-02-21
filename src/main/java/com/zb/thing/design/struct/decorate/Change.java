package com.zb.thing.design.struct.decorate;

public class Change implements TheGreatestSageInterface {
    private TheGreatestSageInterface sage;
    
    public Change(TheGreatestSageInterface sage) {
        this.sage = sage;
    }
    @Override
    public void move() {
        this.sage.move();
    }
}