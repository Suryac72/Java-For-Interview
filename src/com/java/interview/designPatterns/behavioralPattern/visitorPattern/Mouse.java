package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public class Mouse implements ComputerPart {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public String getName() {
        return "Mouse";
    }
}
