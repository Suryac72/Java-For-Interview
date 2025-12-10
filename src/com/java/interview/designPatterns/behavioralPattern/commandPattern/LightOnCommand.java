package com.java.interview.designPatterns.behavioralPattern.commandPattern;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light l) {
        this.light = l;
    }

    @Override
    public void execute() {
        light.on();
    }
}
