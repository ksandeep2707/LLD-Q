package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Coin;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.VendingMachine;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.*;

public class IdleState implements State {

    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoin() {
        System.out.println("Insert Button clicked");
        this.vendingMachine.setState(this.vendingMachine.getHasMoneyState());
    }

    public void insertCoin(Coin coin) {
        throw new InvalidActionException("Cannot Insert Coin in Idle State !!!");
    }

    public void clickSelectProductButton() {
        throw new InvalidActionException("Please Insert Coin first !!!");

    }

    public void selectProduct(String itemid) {
        throw new InvalidActionException("Cannot Select Product in Idle State");
    }

    public void clickProductDispenseProduct() {
        throw new InvalidActionException("Cannot Dispense product..Select Product first !!!");
    }

    public void dispenseProduct(String itemid) {
        throw new InvalidActionException("Cannot Dispense Product in Idle State");
    }

    public void getRefund(int price) {
        throw new InvalidActionException("Cannot Refund Coin in Idle State");
    }

    public void clickCancel() {
        this.vendingMachine.setState(this.vendingMachine.idleState);
    }
}
