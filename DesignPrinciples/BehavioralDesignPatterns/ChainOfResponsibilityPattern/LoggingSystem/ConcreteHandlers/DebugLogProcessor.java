package DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.ConcreteHandlers;

import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.LogLevel;
import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.Handler.LogProcessor;

public class DebugLogProcessor extends LogProcessor {
    public DebugLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void logMessage(LogLevel loglevel, String message) {
        if (loglevel == LogLevel.DEBUG) {
            System.out.println("Debug Message: " + message);
        } else {
            super.logMessage(loglevel, message);
        }
    }
}
