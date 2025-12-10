package com.java.interview.designPatterns.behavioralPattern.commandPattern;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light l) {
        this.light = l;
    }

    @Override
    public void execute() {
        light.off();
    }
}
