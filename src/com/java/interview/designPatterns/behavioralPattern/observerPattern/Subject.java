package com.java.interview.designPatterns.behavioralPattern.observerPattern;

public interface Subject {
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers(String message);
}
