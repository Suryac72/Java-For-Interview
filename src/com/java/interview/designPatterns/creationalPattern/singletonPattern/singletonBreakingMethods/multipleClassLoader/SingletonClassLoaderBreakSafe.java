package com.java.interview.designPatterns.creationalPattern.singletonPattern.singletonBreakingMethods.multipleClassLoader;

import java.io.IOException;

public class SingletonClassLoaderBreakSafe {

    public static void main(String[] args) throws Exception {

        ClassLoader classLoader1 =
                SingletonClassLoaderBreakSafe.class.getClassLoader();
        ClassLoader classLoader2 =
                new CustomClassLoader();

        Class<?> class1 =
                classLoader1.loadClass("com.java.interview.designPatterns.creationalPattern.singletonPattern.implementation.SingletonPatternEager");
        Class<?> class2 =
                classLoader2.loadClass("com.java.interview.designPatterns.creationalPattern.singletonPattern.implementation.SingletonPatternEager");

        Object instance1 =
                class1.getMethod("getInstance").invoke(null);
        Object instance2 =
                class2.getMethod("getInstance").invoke(null);

        System.out.println("Instance 1: " + instance1.hashCode());
        System.out.println("Instance 2: " + instance2.hashCode());
    }
}

class CustomClassLoader extends ClassLoader {
        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            try {
                String path = name.replace('.', '/') + ".class";
                java.io.InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
                byte[] classBytes = inputStream.readAllBytes();
                return defineClass(name, classBytes, 0, classBytes.length);
            } catch (IOException e) {
                throw new ClassNotFoundException(name);
            }
        }
}

