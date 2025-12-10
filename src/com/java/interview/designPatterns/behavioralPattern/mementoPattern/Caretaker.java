package com.java.interview.designPatterns.behavioralPattern.mementoPattern;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
    private final List<Memento> savedStates = new ArrayList<>();

    public void addMemento(Memento m) {
        savedStates.add(m);
    }

    public Memento getMemento(int index) {
        return savedStates.get(index);
    }
}
