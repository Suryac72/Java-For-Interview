package com.java.interview.designPatterns.structuralPattern.flyweightPattern;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static final Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Shape circle = circleMap.get(color);
        if (circle == null) {
            circle = new Circle(color);
            circleMap.put(color, circle);
            System.out.println("Created new circle of color: " + color);
        } else {
            System.out.println("Reusing existing circle of color: " + color);
        }
        return circle;
    }
}
