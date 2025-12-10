package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory;

public class UIFactoryProvider {

    public static UIFactory getFactory(String theme) {
        switch (theme.toLowerCase()) {
        case "light": return new LightFactory();
        case "dark": return new DarkFactory();
        case "highcontrast": return new HighContrastFactory();
        default:
            throw new IllegalArgumentException("Unknown theme: " + theme);
        }
    }
}
