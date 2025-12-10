package com.java.interview.designPatterns.behavioralPattern.chainOfResponsibilityPattern;

public class ChainPatternDemo {
    private static Logger getChainOfLoggers() {
        Logger errorLogger = new ErrorLogger(Logger.ERROR);
        Logger debugLogger = new DebugLogger(Logger.DEBUG);
        Logger infoLogger = new InfoLogger(Logger.INFO);

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);
        return infoLogger;
    }

    public static void main(String[] args) {
        Logger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(Logger.INFO, "This is an info.");
        loggerChain.logMessage(Logger.DEBUG, "This is debug.");
        loggerChain.logMessage(Logger.ERROR, "This is error.");
    }
}
