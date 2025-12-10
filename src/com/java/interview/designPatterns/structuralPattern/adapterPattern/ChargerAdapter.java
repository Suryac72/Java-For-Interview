package com.java.interview.designPatterns.structuralPattern.adapterPattern;

public class ChargerAdapter implements RoundPinCharger {

    private final OldCharger oldCharger;

    public ChargerAdapter(OldCharger oldCharger) {
        this.oldCharger = oldCharger;
    }

    @Override
    public void chargeWithRoundPin() {
        // adapt round-pin call to flat-pin implementation
        oldCharger.chargeWithFlatPin();
    }
}
