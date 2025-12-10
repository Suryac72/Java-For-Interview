package com.java.interview.designPatterns.behavioralPattern.statePattern;

public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();

        StartState start = new StartState();
        start.doAction(context);

        System.out.println("Current State: " + context.getState().getName());

        StopState stop = new StopState();
        stop.doAction(context);

        System.out.println("Current State: " + context.getState().getName());
    }
}
