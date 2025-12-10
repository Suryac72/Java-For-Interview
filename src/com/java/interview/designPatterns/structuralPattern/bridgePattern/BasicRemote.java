package com.java.interview.designPatterns.structuralPattern.bridgePattern;

public class BasicRemote extends Remote {

    public BasicRemote(TV tv) {
        super(tv);
    }

    @Override
    public void pressOn() {
        tv.on();
    }

    @Override
    public void pressOff() {
        tv.off();
    }
}
