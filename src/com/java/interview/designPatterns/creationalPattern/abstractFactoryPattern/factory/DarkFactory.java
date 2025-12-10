package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.*;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.dark.*;

public class DarkFactory implements UIFactory {
    @Override
    public Button createButton() {
        return new DarkButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new DarkCheckbox();
    }
}
