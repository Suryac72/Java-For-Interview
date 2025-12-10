package com.java.interview.designPatterns.behavioralPattern.commandPattern;

public class RemoteControl {
    private Command slot;

    public void setCommand(Command command) {
        slot = command;
    }

    public void pressButton() {
        if (slot != null) slot.execute();
        else System.out.println("No command assigned.");
    }
}
