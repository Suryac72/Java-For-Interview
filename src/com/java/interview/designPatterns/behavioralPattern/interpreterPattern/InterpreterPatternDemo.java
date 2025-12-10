package com.java.interview.designPatterns.behavioralPattern.interpreterPattern;

public class InterpreterPatternDemo {
    // Example: interpret if a given text contains "java" OR "python" and also "tutorial"
    public static void main(String[] args) {
        Expression java = new TerminalExpression("java");
        Expression python = new TerminalExpression("python");
        Expression tutorial = new TerminalExpression("tutorial");

        Expression javaOrPython = new OrExpression(java, python);
        Expression finalExpr = new AndExpression(javaOrPython, tutorial);

        String context1 = "this is a java tutorial";
        String context2 = "this is a python guide";

        System.out.println(context1 + " -> " + finalExpr.interpret(context1)); // true
        System.out.println(context2 + " -> " + finalExpr.interpret(context2)); // false (no tutorial)
    }
}
