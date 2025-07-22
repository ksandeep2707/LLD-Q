package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Exception.IllegalArgumentException;

public class Item {
    private final String itemId;
    private int price;

    public Item(String id, int price) {
        this.itemId = id;
        this.price = price;
    }

    public String getId() {
        return this.itemId;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.price = price;
    }

}
