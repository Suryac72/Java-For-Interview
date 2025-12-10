package com.java.interview.designPatterns.creationalPattern.prototypePattern.implementation;

public class EmployeeLetter implements DocumentPrototype {

    private String header;
    private String body;
    private String footer;
    private String signature;

    public EmployeeLetter(String header, String body, String footer, String signature) {
        this.header = header;
        this.body = body;
        this.footer = footer;
        this.signature = signature;
    }

    @Override
    public DocumentPrototype cloneDocument() {
        try {
            return (EmployeeLetter) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Prototype cloning failed!");
        }
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "\nHeader: " + header +
                "\nBody: " + body +
                "\nFooter: " + footer +
                "\nSignature: " + signature + "\n";
    }
}
