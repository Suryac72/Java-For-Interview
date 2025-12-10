package com.java.interview.designPatterns.behavioralPattern.mediatorPattern;

public class MediatorPatternDemo {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        User u1 = new User("Alice", mediator);
        User u2 = new User("Bob", mediator);
        User u3 = new User("Charlie", mediator);

        mediator.registerUser(u1);
        mediator.registerUser(u2);
        mediator.registerUser(u3);

        u1.send("Hello everyone!");
        u2.send("Hi Alice!");
    }
}
