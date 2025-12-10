package com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation;


public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("📧 Email sent: " + message);
    }
}
