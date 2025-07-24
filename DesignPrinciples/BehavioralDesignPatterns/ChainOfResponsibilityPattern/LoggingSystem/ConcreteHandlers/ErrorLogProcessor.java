package DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.ConcreteHandlers;

import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.LogLevel;
import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.Handler.LogProcessor;

public class ErrorLogProcessor extends LogProcessor {
    public ErrorLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void logMessage(LogLevel loglevel, String message) {
        if (loglevel == LogLevel.ERROR) {
            System.out.println("Error Message: " + message);
        } else {
            super.logMessage(loglevel, message);
        }
    }
}
