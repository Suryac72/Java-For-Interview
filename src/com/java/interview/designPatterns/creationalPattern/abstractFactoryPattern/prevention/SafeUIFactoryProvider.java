package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.prevention;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.DarkFactory;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.HighContrastFactory;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.LightFactory;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.factory.UIFactory;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Safe, thread-safe and secure Abstract Factory Provider.
 * Prevents:
 *  - race conditions
 *  - reflection misuse
 *  - factory mixing
 *  - external overriding of factory definitions
 *  - inconsistent UI object families
 */
public final class SafeUIFactoryProvider {

    // Immutable, preloaded, thread-safe factory registry
    private static final Map<String, UIFactory> FACTORY_MAP = new ConcurrentHashMap<>();

    static {
        // Preload factories only once
        FACTORY_MAP.put("light", new LightFactory());
        FACTORY_MAP.put("dark", new DarkFactory());
        FACTORY_MAP.put("highcontrast", new HighContrastFactory());
    }

    // Private constructor prevents instantiation
    private SafeUIFactoryProvider() {
        throw new UnsupportedOperationException("Cannot instantiate SafeUIFactoryProvider");
    }

    /**
     * Returns a UI factory for a given theme.
     * 
     * @param theme UI theme
     * @return UIFactory instance (thread-safe)
     */
    public static UIFactory getFactory(String theme) {
        if (theme == null)
            throw new IllegalArgumentException("Theme cannot be null");

        UIFactory factory = FACTORY_MAP.get(theme.toLowerCase());

        if (factory == null) {
            throw new IllegalArgumentException("Unknown or unsupported theme: " + theme);
        }

        return factory;
    }

    /**
     * No external registration allowed
     * This prevents unauthorized overriding or injection.
     */
    public static void registerFactory(String theme, UIFactory factory) {
        throw new UnsupportedOperationException("External registration is not allowed in SafeUIFactoryProvider");
    }
}
