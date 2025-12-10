package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.*;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.highcontrast.*;

public class HighContrastFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new HighContrastButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new HighContrastCheckbox();
    }
}
