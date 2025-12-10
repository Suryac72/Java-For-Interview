package com.java.interview.designPatterns.structuralPattern.facadePattern;

public class PaymentService {
    public void processPayment(double amount) {
        System.out.println("Processed payment: $" + amount);
    }
}
