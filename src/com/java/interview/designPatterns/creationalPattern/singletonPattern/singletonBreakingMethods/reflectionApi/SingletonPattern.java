package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.reflectionApi;

import com.java.interview.designPatterns.creationalPattern.singletonPattern.implementation.SingletonPatternEager;
import java.lang.reflect.Constructor;

/**
 * Singleton pattern breaking using Reflection API example. This code
 * demonstrates how the singleton pattern can be compromised using Java's
 * Reflection API.
 */
public class SingletonPattern {

    public static void main(String args[]) throws Exception {

        Constructor<SingletonPatternEager> constructor = SingletonPatternEager.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        SingletonPatternEager newInstance = constructor.newInstance();
        SingletonPatternEager instance = SingletonPatternEager.getInstance();
        System.out.println("Instance 1 hashcode: " + instance.hashCode());
        System.out.println("Instance 2 hashcode: " + newInstance.hashCode());
    }

}
