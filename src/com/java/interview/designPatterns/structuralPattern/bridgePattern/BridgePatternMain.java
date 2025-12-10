package com.java.interview.designPatterns.structuralPattern.bridgePattern;

public class BridgePatternMain {
    public static void main(String[] args) {
        TV sony = new SonyTV();
        Remote remoteForSony = new BasicRemote(sony);
        remoteForSony.pressOn();
        remoteForSony.pressOff();

        TV samsung = new SamsungTV();
        Remote remoteForSamsung = new BasicRemote(samsung);
        remoteForSamsung.pressOn();
        remoteForSamsung.pressOff();
    }
}
