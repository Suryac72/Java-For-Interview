package com.java.interview.designPatterns.creationalPattern.singletonPattern.implementation;

public class SingletonPatternThreadSafe {

    private static SingletonPatternThreadSafe instance;

    private SingletonPatternThreadSafe() {
        // Private constructor to prevent instantiation
    }

    public static SingletonPatternThreadSafe getInstance() {
        synchronized (SingletonPatternThreadSafe.class) {

            if (instance == null) {
                instance = new SingletonPatternThreadSafe();
            }
        }
        return instance;
    }

}
