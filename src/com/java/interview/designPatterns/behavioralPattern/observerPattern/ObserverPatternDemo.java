package com.java.interview.designPatterns.behavioralPattern.observerPattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        Observer o1 = new ConcreteObserver("Observer-1");
        Observer o2 = new ConcreteObserver("Observer-2");

        subject.register(o1);
        subject.register(o2);

        subject.changeState("State-A");

        subject.unregister(o1);

        subject.changeState("State-B");
    }
}
