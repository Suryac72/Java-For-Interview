package com.java.interview.designPatterns.creationalPattern.prototypePattern.breaking;

import com.java.interview.designPatterns.creationalPattern.prototypePattern.implementation.EmployeeLetter;

import java.lang.reflect.Constructor;

public class PrototypeBreaking {

    public static void main(String[] args) throws Exception {

        System.out.println("=== Shallow Copy Break ===");
        shallowCopyBreak();

        System.out.println("\n=== Reflection Break ===");
        reflectionBreak();
    }

    private static void shallowCopyBreak() {
        EmployeeLetter original = new EmployeeLetter(
                "Header", "Original Body", "Footer", "Sign");

        EmployeeLetter copy = (EmployeeLetter) original.cloneDocument();

        // mutate the clone
        copy.setBody("Modified body!");

        System.out.println("Original: " + original);
        System.out.println("Copy: " + copy);
        // shallow copy – original affected if body was reference type
    }

    private static void reflectionBreak() throws Exception {
        Constructor<EmployeeLetter> constructor =
                EmployeeLetter.class.getDeclaredConstructor(String.class, String.class, String.class, String.class);

        constructor.setAccessible(true);

        EmployeeLetter newObj = constructor.newInstance("H", "B", "F", "S");

        System.out.println("Reflection created object → bypassed registry & prototype");
        System.out.println(newObj);
    }
}
