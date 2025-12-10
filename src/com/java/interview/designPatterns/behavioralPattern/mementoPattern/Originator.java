package com.java.interview.designPatterns.behavioralPattern.mementoPattern;

public class Originator {
    private String state;

    public void setState(String state) {
        System.out.println("Originator: Setting state to " + state);
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(state);
    }

    public void restoreFromMemento(Memento m) {
        state = m.getState();
        System.out.println("Originator: State restored to " + state);
    }
}
