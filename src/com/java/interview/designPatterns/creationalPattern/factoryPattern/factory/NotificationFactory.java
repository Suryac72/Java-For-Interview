package com.java.interview.designPatterns.creationalPattern.factoryPattern.factory;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.EmailNotification;
import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.Notification;
import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.PushNotification;
import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.SmsNotification;

public class NotificationFactory {
    
    public Notification createNotification(String type) {
        if (type == null) return null;

        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            case "push" -> new PushNotification();
            default -> throw new IllegalArgumentException("Unknown Notification Type: " + type);
        };
    }
    
}
