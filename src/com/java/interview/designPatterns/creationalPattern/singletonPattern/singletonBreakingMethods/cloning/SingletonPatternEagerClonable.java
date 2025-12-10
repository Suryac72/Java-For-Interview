package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.cloning;

public class SingletonPatternEagerClonable implements Cloneable {

    private static final SingletonPatternEagerClonable INSTANCE = new SingletonPatternEagerClonable();

    private SingletonPatternEagerClonable() {}

    public static SingletonPatternEagerClonable getInstance() {
        return INSTANCE;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
