package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.thread;

public class SingletonPatternThreadBreakSafe {
    public static void main(String[] args) {

        Runnable task = () -> {
            SingletonLazySafe instance = SingletonLazySafe.getInstance();
            System.out.println("Instance: " + instance.hashCode());
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
