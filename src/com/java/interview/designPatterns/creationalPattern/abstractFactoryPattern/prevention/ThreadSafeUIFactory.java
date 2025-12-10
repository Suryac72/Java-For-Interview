package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.prevention;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ThreadSafeUIFactory {

    private static final Map<String, UIFactory> factories = new ConcurrentHashMap<>();

    static {
        factories.put("light", new LightFactory());
        factories.put("dark", new DarkFactory());
        factories.put("highcontrast", new HighContrastFactory());
    }

    public static UIFactory getFactory(String theme) {
        UIFactory factory = factories.get(theme.toLowerCase());
        if (factory == null)
            throw new IllegalArgumentException("Unknown theme: " + theme);
        return factory;
    }
}
