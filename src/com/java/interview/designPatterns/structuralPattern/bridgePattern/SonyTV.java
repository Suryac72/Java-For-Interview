package com.java.interview.designPatterns.structuralPattern.bridgePattern;

public class SonyTV implements TV {
    @Override
    public void on() {
        System.out.println("Sony TV: turned ON");
    }

    @Override
    public void off() {
        System.out.println("Sony TV: turned OFF");
    }
}
