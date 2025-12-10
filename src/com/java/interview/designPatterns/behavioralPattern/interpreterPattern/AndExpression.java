package com.java.interview.designPatterns.behavioralPattern.interpreterPattern;

public class AndExpression implements Expression {
    private final Expression expr1;
    private final Expression expr2;

    public AndExpression(Expression e1, Expression e2) {
        this.expr1 = e1;
        this.expr2 = e2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
