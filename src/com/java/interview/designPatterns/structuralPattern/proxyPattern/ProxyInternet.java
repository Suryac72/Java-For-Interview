package com.java.interview.designPatterns.structuralPattern.proxyPattern;

import java.util.HashSet;
import java.util.Set;

public class ProxyInternet implements Internet {

    private final Internet realInternet = new RealInternet();
    private static final Set<String> bannedSites = new HashSet<>();

    static {
        bannedSites.add("blocked.com");
        bannedSites.add("malware.example");
    }

    @Override
    public void connect(String url) {
        if (bannedSites.contains(url.toLowerCase())) {
            System.out.println("Access denied to " + url);
            return;
        }
        realInternet.connect(url);
    }
}
