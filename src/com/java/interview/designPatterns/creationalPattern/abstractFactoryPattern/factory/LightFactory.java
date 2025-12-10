package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.*;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.light.*;

public class LightFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new LightButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new LightCheckbox();
    }
}
