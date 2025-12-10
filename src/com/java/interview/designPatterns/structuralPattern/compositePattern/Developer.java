package com.java.interview.designPatterns.structuralPattern.compositePattern;

public class Developer implements Employee {

    private final String name;
    private final String role;

    public Developer(String name, String role) {
        this.name = name;
        this.role = role;
    }

    @Override
    public void showDetails() {
        System.out.println("Developer: " + name + " - " + role);
    }
}
