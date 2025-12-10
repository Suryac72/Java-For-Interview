package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public class VisitorPatternDemo {
    public static void main(String[] args) {
        Computer computer = new Computer();
        ComputerPartVisitor visitor = new ComputerPartVisitor();
        computer.accept(visitor);
    }
}
