package com.java.interview.designPatterns.structuralPattern.flyweightPattern;

public class Circle implements Shape {

    private final String color; // intrinsic state

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw(int x, int y, int size) {
        System.out.println("Drawing a " + color + " circle at (" + x + "," + y + ") size " + size);
    }
}
