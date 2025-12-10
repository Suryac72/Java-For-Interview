package com.java.interview.designPatterns.structuralPattern.compositePattern;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Employee {

    private final String name;
    private final String role;
    private final List<Employee> team = new ArrayList<>();

    public Manager(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void add(Employee e) {
        team.add(e);
    }

    public void remove(Employee e) {
        team.remove(e);
    }

    @Override
    public void showDetails() {
        System.out.println("Manager: " + name + " - " + role);
        for (Employee e : team) {
            System.out.print("  -> ");
            e.showDetails();
        }
    }
}
