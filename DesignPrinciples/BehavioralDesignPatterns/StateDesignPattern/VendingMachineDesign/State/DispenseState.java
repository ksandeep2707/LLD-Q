package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Coin;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Item;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.VendingMachine;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.InsufficientBalanceException;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.InvalidActionException;

public class DispenseState implements State {
    VendingMachine vendingMachine;

    public DispenseState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoin() {
        throw new InvalidActionException("Please select Product or click cancel to go back !!!");
    }

    public void insertCoin(Coin coin) {
        throw new InvalidActionException("Cannot Insert Coin Product in Dispense State");
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
        System.out.println("Dispensing product....");
        Item item = this.vendingMachine.getInventory().getItem(itemid);
        int amount = 0;
        for (Coin coin : this.vendingMachine.getCoins()) {
            amount += coin.getValue();
        }
        if (amount < item.getPrice())
            throw new InsufficientBalanceException("Insufficient Balance..");

        this.vendingMachine.setState(this.vendingMachine.getRefundState());
        this.vendingMachine.getCurrentState().getRefund(amount - item.getPrice());
    }

    public void getRefund(int price) {
        throw new InvalidActionException("Cannot Refund Coin in Selection Product State");
    }

    public void clickCancel() {
        throw new InvalidActionException("Illegal operation...");
    }
}
