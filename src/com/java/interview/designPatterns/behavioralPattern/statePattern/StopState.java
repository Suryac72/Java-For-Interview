package com.java.interview.designPatterns.behavioralPattern.statePattern;

public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state.");
        context.setState(this);
    }

    @Override
    public String getName() {
        return "StopState";
    }
}
