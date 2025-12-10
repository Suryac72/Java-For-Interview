package com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryPrevention;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Supplier;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.*;

public class SafeFactoryWithPrevention {

    private static final Map<String, Supplier<Notification>> registry = new ConcurrentHashMap<>();

    static {
        register("email", EmailNotification::new);
        register("sms", SmsNotification::new);
        register("push", PushNotification::new);
    }

    public static void register(String type, Supplier<Notification> supplier) {
        if (registry.containsKey(type))
            throw new RuntimeException("Modification of existing type not allowed: " + type);

        registry.put(type.toLowerCase(), supplier);
    }

    public static Notification create(String type) {
        Supplier<Notification> supplier = registry.get(type.toLowerCase());
        if (supplier == null)
            throw new IllegalArgumentException("Unknown notification type: " + type);

        return supplier.get();
    }
}
