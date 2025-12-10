package com.java.interview.designPatterns.behavioralPattern.commandPattern;

public class Light {
    private boolean on = false;

    public void on() {
        on = true;
        System.out.println("Light is ON");
    }

    public void off() {
        on = false;
        System.out.println("Light is OFF");
    }
}
