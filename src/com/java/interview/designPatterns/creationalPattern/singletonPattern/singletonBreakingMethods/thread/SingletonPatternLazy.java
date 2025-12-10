package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.thread;

public class SingletonPatternLazy {

    private static SingletonPatternLazy instance;

    private SingletonPatternLazy() {}

    public static SingletonPatternLazy getInstance() {
        if (instance == null) { // race condition here
            instance = new SingletonPatternLazy();
        }
        return instance;
    }
}
