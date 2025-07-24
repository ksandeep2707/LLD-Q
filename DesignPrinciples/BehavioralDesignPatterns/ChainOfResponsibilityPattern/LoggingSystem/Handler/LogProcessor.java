package DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.Handler;

import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.LogLevel;

public abstract class LogProcessor {
    LogProcessor nextLoggerProcessor = null;

    public LogProcessor(LogProcessor nextLogProcessor) {
        this.nextLoggerProcessor = nextLogProcessor;
    }

    public void logMessage(LogLevel loglevel, String message) {
        if (nextLoggerProcessor != null) {
            nextLoggerProcessor.logMessage(loglevel, message);
        }
    }

}
