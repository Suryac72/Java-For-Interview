package com.java.interview.designPatterns.behavioralPattern.templatePattern;

public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
