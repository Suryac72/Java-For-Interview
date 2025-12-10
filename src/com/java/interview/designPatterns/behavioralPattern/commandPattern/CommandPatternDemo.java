package com.java.interview.designPatterns.behavioralPattern.commandPattern;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Light lamp = new Light();
        Command lightOn = new LightOnCommand(lamp);
        Command lightOff = new LightOffCommand(lamp);

        RemoteControl remote = new RemoteControl();
        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
