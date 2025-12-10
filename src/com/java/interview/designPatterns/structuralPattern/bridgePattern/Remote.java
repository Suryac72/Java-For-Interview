package com.java.interview.designPatterns.structuralPattern.bridgePattern;

public abstract class Remote {
    protected TV tv;

    protected Remote(TV tv) {
        this.tv = tv;
    }

    public abstract void pressOn();
    public abstract void pressOff();
}
