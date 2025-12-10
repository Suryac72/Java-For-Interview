package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.highcontrast;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Checkbox;

public class HighContrastCheckbox implements Checkbox {
    @Override
    public void click() {
        System.out.println("High-Contrast Checkbox Clicked");
    }
}
