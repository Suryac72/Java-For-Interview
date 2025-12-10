package com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation;

public class PushNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("🔔 Push Notification: " + message);
    }
}