package com.java.interview.designPatterns.structuralPattern.compositePattern;

public class CompositePatternMain {
    public static void main(String[] args) {
        Developer d1 = new Developer("Alice", "Backend");
        Developer d2 = new Developer("Bob", "Frontend");

        Manager m1 = new Manager("Carol", "Engineering Manager");
        m1.add(d1);
        m1.add(d2);

        Developer d3 = new Developer("Eve", "QA");
        Manager m2 = new Manager("Dave", "Director");
        m2.add(m1);
        m2.add(d3);

        m2.showDetails();
    }
}
