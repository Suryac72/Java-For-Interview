package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.multipleClassLoader;

public class SingletonClassLoaderBreakSafe {

    public static void main(String[] args) throws Exception {
        SingletonSafeEnum instance1 = SingletonSafeEnum.INSTANCE;
        SingletonSafeEnum instance2 = SingletonSafeEnum.INSTANCE;
        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode());

    }
}
