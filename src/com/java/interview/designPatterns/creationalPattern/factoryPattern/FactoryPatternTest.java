package com.java.interview.designPatterns.creationalPattern.factoryPattern;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.factory.NotificationFactory;
import com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation.Notification;

public class FactoryPatternTest {

    public static void main(String[] args) {
        Notification n = null;
        try {
            n = new NotificationFactory().createNotification("email");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        n.send("Hello World!");
    }
}
