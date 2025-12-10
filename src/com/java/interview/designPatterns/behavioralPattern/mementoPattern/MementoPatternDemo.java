package com.java.interview.designPatterns.behavioralPattern.mementoPattern;

public class MementoPatternDemo {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State1");
        caretaker.addMemento(originator.saveToMemento());

        originator.setState("State2");
        caretaker.addMemento(originator.saveToMemento());

        originator.setState("State3");
        System.out.println("Current State: " + originator.getState());

        originator.restoreFromMemento(caretaker.getMemento(1));
        System.out.println("After restore: " + originator.getState());
    }
}
