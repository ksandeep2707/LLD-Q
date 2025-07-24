package DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem;

import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.ConcreteHandlers.DebugLogProcessor;
import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.ConcreteHandlers.ErrorLogProcessor;
import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.ConcreteHandlers.InfoLogProcessor;
import DesignPrinciples.BehavioralDesignPatterns.ChainOfResponsibilityPattern.LoggingSystem.Handler.LogProcessor;

public class Client {
    public static void main(String[] args) {
        LogProcessor logProcessor = new InfoLogProcessor(new DebugLogProcessor(new ErrorLogProcessor(null)));

        logProcessor.logMessage(LogLevel.INFO, "This is an Info Message !");
        logProcessor.logMessage(LogLevel.DEBUG, "This is an Debug Message !");
        logProcessor.logMessage(LogLevel.ERROR, "This is an Error Message !");
    }
}
