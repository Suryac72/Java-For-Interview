package com.java.interview.designPatterns.behavioralPattern.strategyPattern;

public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context ctx = new Context(new OperationAdd());
        System.out.println("Add: " + ctx.executeStrategy(5, 3));

        ctx.setStrategy(new OperationSubtract());
        System.out.println("Subtract: " + ctx.executeStrategy(5, 3));

        ctx.setStrategy(new OperationMultiply());
        System.out.println("Multiply: " + ctx.executeStrategy(5, 3));
    }
}
