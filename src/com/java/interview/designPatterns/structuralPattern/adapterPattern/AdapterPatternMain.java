package com.java.interview.designPatterns.structuralPattern.adapterPattern;

public class AdapterPatternMain {
    public static void main(String[] args) {
        OldCharger oldCharger = new OldCharger();
        RoundPinCharger adapter = new ChargerAdapter(oldCharger);
        adapter.chargeWithRoundPin();
    }
}
