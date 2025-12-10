package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public class Computer implements ComputerPart {
    private final ComputerPart[] parts;

    public Computer() {
        parts = new ComputerPart[] { new Mouse(), new Keyboard(), new Monitor() };
    }

    @Override
    public void accept(Visitor visitor) {
        for (ComputerPart p : parts) {
            p.accept(visitor);
        }
        visitor.visit(this);
    }

    public String getName() {
        return "Computer";
    }
}
