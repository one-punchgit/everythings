package com.zb.thing.design.struct.decorate;

/**
 * 结构型模式-装饰器
 */
public class Test {
    public static void main(String[] args) {
        TheGreatestSageInterface theGreatestSageInterface = new Monkey();

        theGreatestSageInterface.move();
        Fish fish = new Fish(theGreatestSageInterface);

        fish.move();
    }
}
