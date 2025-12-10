package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.reflectionApi;

public class SingletonSafeReflection {

    private static final SingletonSafeReflection INSTANCE = new SingletonSafeReflection();

    private SingletonSafeReflection() {
        if (INSTANCE != null) {
            throw new RuntimeException("Reflection attack blocked!");
        }
    }

    public static SingletonSafeReflection getInstance() {
        return INSTANCE;
    }
}
