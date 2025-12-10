package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public class ComputerPartVisitor implements Visitor {
    @Override
    public void visit(Mouse mouse) {
        System.out.println("Visiting " + mouse.getName());
    }

    @Override
    public void visit(Keyboard keyboard) {
        System.out.println("Visiting " + keyboard.getName());
    }

    @Override
    public void visit(Monitor monitor) {
        System.out.println("Visiting " + monitor.getName());
    }

    @Override
    public void visit(Computer computer) {
        System.out.println("Visiting " + computer.getName());
    }
}
