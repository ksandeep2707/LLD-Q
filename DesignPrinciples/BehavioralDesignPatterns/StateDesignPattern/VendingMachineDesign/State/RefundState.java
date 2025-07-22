package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Coin;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.VendingMachine;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.InvalidActionException;

public class RefundState implements State {
    VendingMachine vendingMachine;

    public RefundState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoin() {
        throw new InvalidActionException("Illegal operation...");
    }

    public void insertCoin(Coin coin) {
        throw new InvalidActionException("CIllegal operation...");
    }

    public void clickSelectProductButton() {
        throw new InvalidActionException("Illegal operation...");
    }

    public void selectProduct(String itemid) {
        throw new InvalidActionException("Illegal operation...");
    }

    public void clickProductDispenseProduct() {
        throw new InvalidActionException("Illegal operation...");
    }

    public void dispenseProduct(String itemid) {
        throw new InvalidActionException("Illegal operation...");
    }

    public void getRefund(int price) {
        System.out.println("Thankyou For Shopping ....");
        System.out.println("Your Change: " + price);
        this.vendingMachine.setState(this.vendingMachine.getIdleState());
    }

    public void clickCancel() {
        throw new InvalidActionException("Illegal operation...");
    }
}
