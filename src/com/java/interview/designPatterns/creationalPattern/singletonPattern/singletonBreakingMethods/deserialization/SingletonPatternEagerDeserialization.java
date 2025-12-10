package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.deserialization;

import java.io.Serializable;

public class SingletonPatternEagerDeserialization implements Serializable {

    private static final SingletonPatternEagerDeserialization INSTANCE = new SingletonPatternEagerDeserialization();

    private SingletonPatternEagerDeserialization() {}

    public static SingletonPatternEagerDeserialization getInstance() {
        return INSTANCE;
    }
}
