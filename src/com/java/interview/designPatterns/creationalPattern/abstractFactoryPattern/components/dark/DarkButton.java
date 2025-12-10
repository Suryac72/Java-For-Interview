package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.dark;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Button;

public class DarkButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Dark Theme Button");
    }
}
