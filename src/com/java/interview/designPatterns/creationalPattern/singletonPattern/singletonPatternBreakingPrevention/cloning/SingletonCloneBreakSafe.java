package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.cloning;

public class SingletonCloneBreakSafe {

    public static void main(String[] args) throws Exception {

        SingletonSafeClone instance1 = SingletonSafeClone.getInstance();
        SingletonSafeClone instance2 = (SingletonSafeClone) instance1.clone();

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode()); 
    }
}
