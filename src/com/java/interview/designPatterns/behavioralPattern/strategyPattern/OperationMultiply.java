package com.java.interview.designPatterns.behavioralPattern.strategyPattern;

public class OperationMultiply implements Strategy {
    @Override
    public int execute(int a, int b) {
        return a * b;
    }
}
