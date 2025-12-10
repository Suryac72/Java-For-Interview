package com.java.interview.designPatterns.creationalPattern.prototypePattern.prevention;

import com.java.interview.designPatterns.creationalPattern.prototypePattern.implementation.DocumentPrototype;

public class SafePrototype implements DocumentPrototype {

    private String header;
    private String body;
    private String footer;
    private String signature;

    private static boolean creationAllowed = false;

    public SafePrototype(String header, String body, String footer, String signature) {
        if (!creationAllowed)
            throw new RuntimeException("Direct object creation not allowed! Use cloneDocument()");
        this.header = header;
        this.body = body;
        this.footer = footer;
        this.signature = signature;
    }

    @Override
    public DocumentPrototype cloneDocument() {
        creationAllowed = true;
        SafePrototype clone = new SafePrototype(header, body, footer, signature);
        creationAllowed = false;
        return clone;
    }
}
