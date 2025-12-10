package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.dark;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Checkbox;

public class DarkCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("Dark Theme Checkbox Clicked");
    }
}
