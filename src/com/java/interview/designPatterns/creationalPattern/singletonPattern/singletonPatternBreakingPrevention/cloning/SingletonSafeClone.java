package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.cloning;

public class SingletonSafeClone implements Cloneable {

    private static final SingletonSafeClone INSTANCE = new SingletonSafeClone();

    private SingletonSafeClone() {}

    public static SingletonSafeClone getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return INSTANCE; 
    }
}