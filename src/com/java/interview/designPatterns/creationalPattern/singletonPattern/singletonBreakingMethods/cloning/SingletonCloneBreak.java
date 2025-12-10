package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.cloning;

public class SingletonCloneBreak {

    public static void main(String[] args) throws Exception {

        SingletonPatternEagerClonable instance1 = SingletonPatternEagerClonable.getInstance();
        SingletonPatternEagerClonable instance2 = (SingletonPatternEagerClonable) instance1.clone();

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode()); // Different
    }
}
