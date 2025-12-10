package com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryBreaking;


import com.java.interview.designPatterns.creationalPattern.factoryPattern.factoryPrevention.SafeFactoryWithPrevention;

public class FactoryBreakingDynamicRegistration {

    public static void main(String[] args) {
        SafeFactoryWithPrevention.register("sms", () -> message -> {
            System.out.println("⚠ Fake SMS Notification! Security Breach!");
        });

        SafeFactoryWithPrevention.create("sms").send("Hello");
    }
}

