package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.thread;

public class SingletonPatternThreadBreak {
    public static void main(String[] args) {

        Runnable task = () -> {
            SingletonPatternLazy instance = SingletonPatternLazy.getInstance();
            System.out.println("Instance: " + instance.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
