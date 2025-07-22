package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign;

import java.util.*;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State.*;

public class VendingMachine {
    State currentState;
    Inventory inventory;
    List<Coin> coins;

    public final State idleState = new IdleState(this);
    public final State hasMoneyState = new HasMoneyState(this);
    public final State selectionState = new SelectionState(this);
    public final State dispenseState = new DispenseState(this);
    public final State refundState = new RefundState(this);

    public VendingMachine() {
        this.currentState = idleState;
        this.inventory = new Inventory("India");
        this.coins = new ArrayList<>();
    }

    public State getCurrentState() {
        return this.currentState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public State getIdleState() {
        return this.idleState;
    }

    public State getHasMoneyState() {
        return this.hasMoneyState;
    }

    public State getSelectionState() {
        return this.selectionState;
    }

    public State getDispenseState() {
        return this.dispenseState;
    }

    public State getRefundState() {
        return this.refundState;
    }

    public void insertCoin(Coin coin) {
        coins.add(coin);
    }

    public List<Coin> getCoins() {
        return this.coins;
    }

    public void removeCoin(Coin coin) {
        coins.remove(coin);
    }

    public Inventory getInventory(){
        return this.inventory;
    }

}
