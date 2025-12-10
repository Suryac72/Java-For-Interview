package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.thread;

public class SingletonLazySafe {

    private static SingletonLazySafe instance;

    private SingletonLazySafe() {
    }

    public static synchronized SingletonLazySafe getInstance() {
        if (instance == null) {
            instance = new SingletonLazySafe();
        }
        return instance;
    }

    //Double-Checked Locking + volatile keyword
    public static SingletonLazySafe getInstanceVolatile() {
        if (instance == null) {
            synchronized (SingletonLazySafe.class) {
                if (instance == null) {
                    instance = new SingletonLazySafe();
                }
            }
        }
        return instance;
    }

}
