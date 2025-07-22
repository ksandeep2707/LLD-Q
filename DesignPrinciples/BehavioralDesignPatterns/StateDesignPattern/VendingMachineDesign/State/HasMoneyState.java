package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Coin;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.VendingMachine;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.InvalidActionException;

public class HasMoneyState implements State {

    VendingMachine vendingMachine;

    public HasMoneyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoin() {
        throw new InvalidActionException("Please Insert Coin or click cancel to go back !!!");
    }

    public void insertCoin(Coin coin) {
        System.out.println("Inserted Coin : "+coin.getValue());
        this.vendingMachine.insertCoin(coin);
    }

    public void clickSelectProductButton() {
        System.out.println("Please select product...");
        this.vendingMachine.setState(this.vendingMachine.getSelectionState());
    }

    public void selectProduct(String itemid) {
        throw new InvalidActionException("Cannot Select Product in HasMoneyState State");
    }

    public void clickProductDispenseProduct() {
        throw new InvalidActionException("Cannot Dispense product..Select Product first !!!");
    }

    public void dispenseProduct(String itemid) {
        throw new InvalidActionException("Cannot Dispense Product in HasMoney State");
    }

    public void getRefund(int price) {
        throw new InvalidActionException("Cannot Refund Coin in HasMoney State");
    }

    public void clickCancel() {
        this.vendingMachine.setState(this.vendingMachine.getRefundState());
        int amount=0;
        for(Coin coin :this.vendingMachine.getCoins()){
            amount+=coin.getValue();
        }
        this.vendingMachine.getCurrentState().getRefund(amount);
    }

}
