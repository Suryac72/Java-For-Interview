package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public class Keyboard implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return "Keyboard";
    }
}
