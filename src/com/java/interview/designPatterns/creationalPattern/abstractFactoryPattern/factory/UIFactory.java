package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Button;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Checkbox;

public interface UIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
