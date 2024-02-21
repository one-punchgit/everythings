package com.zb.thing.design.struct.decorate1;

public class BorderDecorator extends ShapeDecorator {
    public BorderDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }
    
    @Override
    public void draw() {
        decoratedShape.draw();
        addBorder();
    }
    
    private void addBorder() {
        System.out.println("Adding border to the shape.");
    }
}
