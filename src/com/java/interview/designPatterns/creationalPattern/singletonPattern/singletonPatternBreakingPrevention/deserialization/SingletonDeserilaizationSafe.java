package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonPatternBreakingPrevention.deserialization;

import java.io.*;

public class SingletonDeserilaizationSafe {

    public static void main(String[] args) throws Exception {

        SingletonPatternEagerDeserialization instance1 = SingletonPatternEagerDeserialization.getInstance();

        try ( // Serialize
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.obj"))) {
            out.writeObject(instance1);
        }

        SingletonPatternEagerDeserialization instance2;
        try ( // Deserialize
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.obj"))) {
            instance2 = (SingletonPatternEagerDeserialization) in.readObject();
        }

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode()); // Different
    }
}
