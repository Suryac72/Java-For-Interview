package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.light;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Button;

public class LightButton implements Button {
    @Override
    public void render() {
        System.out.println("Rendering Light Theme Button");
    }
}
