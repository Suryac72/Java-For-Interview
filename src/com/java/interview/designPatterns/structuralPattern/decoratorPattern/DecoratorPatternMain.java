package com.java.interview.designPatterns.structuralPattern.decoratorPattern;

public class DecoratorPatternMain {
    public static void main(String[] args) {
        Coffee coffee = new BasicCoffee();
        System.out.println(coffee.getDescription() + " $" + coffee.getCost());

        coffee = new MilkDecorator(coffee);
        coffee = new SugarDecorator(coffee);

        System.out.println(coffee.getDescription() + " $" + coffee.getCost());
    }
}
