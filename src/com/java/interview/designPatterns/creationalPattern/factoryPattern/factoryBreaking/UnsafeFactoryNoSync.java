package com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryBreaking;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.*;

public class UnsafeFactoryNoSync {

    private static final Map<String, Supplier<Notification>> registry = new HashMap<>();

    public static void register(String type, Supplier<Notification> supplier) {
        registry.put(type, supplier);   // NOT THREAD SAFE
    }

    public static Notification create(String type) {
        return registry.get(type).get();
    }
}
