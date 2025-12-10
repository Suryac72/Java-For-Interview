package com.java.interview.designPatterns.creationalPattern.builderPattern;


import com.java.interview.designPatterns.creationalPattern.builderPattern.implementation.Burger;

public class BuilderDemo {
    public static void main(String[] args) {

        Burger burger = new Burger.Builder()
                .setBun("sesame")
                .setPatty("double chicken")
                .addCheese(true)
                .addMayo(true)
                .setDrink("Coke")
                .build();

        System.out.println(burger);
    }
}
