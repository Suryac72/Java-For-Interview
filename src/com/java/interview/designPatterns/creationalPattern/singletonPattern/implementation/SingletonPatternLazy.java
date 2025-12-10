package com.java.interview.designPatterns.creationalPattern.singletonPattern.implementation;
/**
 * Lazy Initialization Singleton Pattern
 * In this implementation, the singleton instance is created only when it is requested for the first time.
 * This approach can save resources if the instance is never needed.
 * However, it is not thread-safe and may require additional synchronization in multi-threaded environment.
 * Example Usage in real-world scenarios includes database connection pools, configuration settings, etc.
 */
public class SingletonPatternLazy {

    private static SingletonPatternLazy instance;

    private SingletonPatternLazy() {
        // Private constructor to prevent instantiation
    }

    public static SingletonPatternLazy getInstance() {
        if (instance == null) {
            instance = new SingletonPatternLazy();
        }
        return instance;
    }

}
