package com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.prevention;

import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.*;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.dark.*;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.highcontrast.*;
import com.java.interview.designPatterns.creationalPattern.abstractFactoryPattern.components.light.*;

public enum EnumSafeFactory {

    LIGHT {
        public Button button() { return new LightButton(); }
        public Checkbox checkbox() { return new LightCheckbox(); }
    },

    DARK {
        public Button button() { return new DarkButton(); }
        public Checkbox checkbox() { return new DarkCheckbox(); }
    },

    HIGHCONTRAST {
        public Button button() { return new HighContrastButton(); }
        public Checkbox checkbox() { return new HighContrastCheckbox(); }
    };

    public abstract Button button();
    public abstract Checkbox checkbox();
}
