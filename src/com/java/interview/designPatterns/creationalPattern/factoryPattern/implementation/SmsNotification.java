package com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation;

public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📱 SMS sent: " + message);
    }
}