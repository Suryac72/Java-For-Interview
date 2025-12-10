package com.java.interview.designPatterns.behavioralPattern.visitorPattern;

public interface Visitor {
    void visit(Mouse mouse);
    void visit(Keyboard keyboard);
    void visit(Monitor monitor);
    void visit(Computer computer);
}
