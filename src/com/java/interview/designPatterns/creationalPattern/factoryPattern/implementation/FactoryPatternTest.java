package com.java.interview.designPatterns.creationalPattern.factoryPattern.implementation;

import com.java.interview.designPatterns.creationalPattern.factoryPattern.factory.NotificationFactory;

public class FactoryPatternTest {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.createNotification("email");
        email.send("Welcome to our platform!");

        Notification sms = factory.createNotification("sms");
        sms.send("Your OTP is 123456");

        Notification push = factory.createNotification("push");
        push.send("You have a new message!");
    }
}
