package com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryPrevention;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.*;

public enum SafeFactoryEnum {

    INSTANCE;

    public Notification create(String type) {
        switch (type.toLowerCase()) {
        case "email": return new EmailNotification();
        case "sms": return new SmsNotification();
        case "push": return new PushNotification();
        default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
