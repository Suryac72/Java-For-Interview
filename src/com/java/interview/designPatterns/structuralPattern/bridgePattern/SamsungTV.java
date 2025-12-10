package com.java.interview.designPatterns.structuralPattern.bridgePattern;

public class SamsungTV implements TV {
    @Override
    public void on() {
        System.out.println("Samsung TV: turned ON");
    }

    @Override
    public void off() {
        System.out.println("Samsung TV: turned OFF");
    }
}
