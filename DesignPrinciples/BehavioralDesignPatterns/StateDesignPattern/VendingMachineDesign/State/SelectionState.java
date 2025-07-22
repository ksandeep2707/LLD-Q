package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Coin;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.VendingMachine;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.IllegalArgumentException;
import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.InvalidActionException;

public class SelectionState implements State {

    VendingMachine vendingMachine;
    private String selectedItemId;

    public SelectionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void clickOnInsertCoin() {
        throw new InvalidActionException("Please select Product or click cancel to go back !!!");
    }

    public void insertCoin(Coin coin) {
        throw new InvalidActionException("Cannot Insert Coin Product in Section State");
    }

    public void clickSelectProductButton() {
        throw new InvalidActionException("Please Select Product you are already in Production selection state");
    }

    public void selectProduct(String itemid) {
        System.out.println("Item Selected Successfully.. Click on Dispense Product..");
        this.selectedItemId = itemid;
    }

    public void clickProductDispenseProduct() {
        if (this.selectedItemId == null) {
            throw new IllegalArgumentException("Please Select product first..");
        }
        this.vendingMachine.setState(this.vendingMachine.getDispenseState());
        this.vendingMachine.getCurrentState().dispenseProduct(this.selectedItemId);
    }

    public void dispenseProduct(String itemid) {
        throw new InvalidActionException("Please click on dispense Product...");
    }

    public void getRefund(int price) {
        throw new InvalidActionException("Cannot Refund Coin in Selection Product State");
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
