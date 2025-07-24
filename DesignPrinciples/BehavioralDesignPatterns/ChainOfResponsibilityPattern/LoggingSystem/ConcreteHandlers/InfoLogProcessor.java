package DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.ConcreteHandlers;

import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.LogLevel;
import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.Handler.LogProcessor;

public class InfoLogProcessor extends LogProcessor {
    public InfoLogProcessor(LogProcessor nextLogProcessor) {
        super(nextLogProcessor);
    }

    public void logMessage(LogLevel loglevel, String message) {
        if (loglevel == LogLevel.INFO) {
            System.out.println("Info Message: " + message);
        } else {
            super.logMessage(loglevel, message);
        }
    }
}
