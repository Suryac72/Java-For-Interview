package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.breaking;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.dark.DarkButton;
import java.lang.reflect.Constructor;

public class BreakingReflection {
    public static void main(String[] args) throws Exception {
        Constructor<DarkButton> c = DarkButton.class.getDeclaredConstructor();
        c.setAccessible(true);

        DarkButton hackedBtn = c.newInstance();
        hackedBtn.render();
    }
}
