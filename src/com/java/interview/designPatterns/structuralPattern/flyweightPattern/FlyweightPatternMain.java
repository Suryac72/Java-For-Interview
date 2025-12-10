package com.java.interview.designPatterns.structuralPattern.flyweightPattern;

public class FlyweightPatternMain {
    public static void main(String[] args) {
        Shape c1 = ShapeFactory.getCircle("Red");
        c1.draw(10, 20, 5);

        Shape c2 = ShapeFactory.getCircle("Blue");
        c2.draw(30, 40, 10);

        Shape c3 = ShapeFactory.getCircle("Red");
        c3.draw(50, 60, 15);
    }
}
