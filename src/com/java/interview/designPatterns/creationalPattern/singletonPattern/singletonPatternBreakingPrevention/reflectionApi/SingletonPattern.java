package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.reflectionApi;

import java.lang.reflect.Constructor;

/**
 * Singleton pattern breaking using Reflection API example. This code
 * demonstrates how the singleton pattern can be compromised using Java's
 * Reflection API.
 */
public class SingletonPattern {

    public static void main(String args[]) throws Exception {

        Constructor<SingletonSafeReflection> constructor = SingletonSafeReflection.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonSafeReflection newInstance = constructor.newInstance();
        SingletonSafeReflection instance = SingletonSafeReflection.getInstance();
        System.out.println("Instance 1 hashcode: " + instance.hashCode());
        System.out.println("Instance 2 hashcode: " + newInstance.hashCode());
    }

}
