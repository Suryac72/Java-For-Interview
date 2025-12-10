package com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryPrevention;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SafeFactoryThreadSafe {

    private static final Map<String, Class<? extends Notification>> registry = new ConcurrentHashMap<>();

    static {
        registry.put("email", EmailNotification.class);
        registry.put("sms", SmsNotification.class);
        registry.put("push", PushNotification.class);
    }

    public static Notification create(String type) {
        Class<? extends Notification> clazz = registry.get(type);
        if (clazz == null)
            throw new IllegalArgumentException("Unknown notification type: " + type);

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create notification", e);
        }
    }
}
