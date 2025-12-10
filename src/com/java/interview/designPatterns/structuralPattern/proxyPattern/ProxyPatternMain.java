package com.java.interview.designPatterns.structuralPattern.proxyPattern;

public class ProxyPatternMain {
    public static void main(String[] args) {
        Internet internet = new ProxyInternet();
        internet.connect("example.com");
        internet.connect("blocked.com");
    }
}
