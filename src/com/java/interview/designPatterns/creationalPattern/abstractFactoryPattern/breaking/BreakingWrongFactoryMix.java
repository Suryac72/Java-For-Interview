package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.breaking;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.dark.DarkButton;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.LightFactory;

public class BreakingWrongFactoryMix {

    public static void main(String[] args) {
        LightFactory lightFactory = new LightFactory();

        // Wrong combination → Violates Abstract Factory principle
        DarkButton darkButton = new DarkButton();
        lightFactory.createCheckbox().click(); // Light Checkbox
        darkButton.render();                   // Dark Button
    }
}
