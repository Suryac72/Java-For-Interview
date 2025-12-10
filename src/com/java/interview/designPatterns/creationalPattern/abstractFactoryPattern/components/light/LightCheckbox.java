package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.light;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Checkbox;

public class LightCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("Light Theme Checkbox Clicked");
    }
}
