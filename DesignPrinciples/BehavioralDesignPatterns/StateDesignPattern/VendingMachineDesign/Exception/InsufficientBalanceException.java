package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception;

public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}
