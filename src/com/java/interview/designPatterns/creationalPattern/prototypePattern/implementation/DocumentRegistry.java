package com.java.interview.designPatterns.creationalPattern.prototypePattern.implementation;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {

    private static final Map<String, DocumentPrototype> registry = new HashMap<>();

    static {
        registry.put("offer", new EmployeeLetter(
                "Company XYZ",
                "Dear Candidate, This is your offer letter...",
                "Best Regards",
                "HR Department"));
    }

    public static DocumentPrototype getDocument(String type) {
        DocumentPrototype prototype = registry.get(type.toLowerCase());
        if (prototype == null)
            throw new IllegalArgumentException("Unknown template: " + type);
        return prototype.cloneDocument();
    } 
}
