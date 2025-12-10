package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Button;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.Checkbox;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.UIFactory;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.UIFactoryProvider;

public class AbstractFactoryDemo {

    public static void main(String[] args) {
        UIFactory factory = UIFactoryProvider.getFactory("dark");

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();

        checkbox.click();
    }

}
