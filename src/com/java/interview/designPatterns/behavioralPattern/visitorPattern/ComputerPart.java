package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public interface ComputerPart {
    void accept(Visitor visitor);
}
