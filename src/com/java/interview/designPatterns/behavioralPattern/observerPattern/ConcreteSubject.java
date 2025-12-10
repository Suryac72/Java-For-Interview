package com.java.interview.designPatterns.behavioralPattern.observerPattern;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    // business method
    public void changeState(String newState) {
        System.out.println("Subject changed state: " + newState);
        notifyObservers(newState);
    }
}
