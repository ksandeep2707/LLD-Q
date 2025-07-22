package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception;

public class InvalidActionException extends RuntimeException {
    public InvalidActionException(String message) {
        super(message);
    }
}
