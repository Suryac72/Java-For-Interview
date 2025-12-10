package com.java.interview.designPatterns.behavioralPattern.statePattern;

public interface State {
    void doAction(Context context);
    String getName();
}
