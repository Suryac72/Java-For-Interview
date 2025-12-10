package com.java.interview.designPatterns.structuralPattern.facadePattern;

public class FacadePatternMain {
    public static void main(String[] args) {
        TravelFacade facade = new TravelFacade();
        facade.bookTrip("Seaside Resort", "SK123", 499.99);
    }
}
