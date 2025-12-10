package com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryBreaking;

import java.lang.reflect.Constructor;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.EmailNotification;
import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.Notification;

public class FactoryBreakingReflection {

    public static void main(String[] args) throws Exception {
        Constructor<EmailNotification> constructor = EmailNotification.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        Notification hackedInstance = constructor.newInstance();
        hackedInstance.send("Reflection broke factory!");
    }
}
