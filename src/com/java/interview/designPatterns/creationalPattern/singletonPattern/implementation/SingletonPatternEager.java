package com.java.interview.designPatterns.creationalPattern.singletonPattern.implementation;

/**
 * Eager Initialization Singleton Pattern
 * In this implementation, the singleton instance is created at the time of class loading.
 * Example usage in real-world scenarios includes logging, caching, thread pool management, etc.
 */
public class SingletonPatternEager {

    private static final SingletonPatternEager singletonPatternEager = new SingletonPatternEager();

    private SingletonPatternEager() {
        // Private constructor to prevent instantiation
    }

    public static SingletonPatternEager getInstance() {
        return singletonPatternEager;
    }

}