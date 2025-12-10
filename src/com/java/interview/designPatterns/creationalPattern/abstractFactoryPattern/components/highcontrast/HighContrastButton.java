package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.highcontrast;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Button;

public class HighContrastButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering High-Contrast Theme Button");
    }
}
