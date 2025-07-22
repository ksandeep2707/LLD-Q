package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign;

import java.util.*;

public class Inventory {
    private Map<String, Item> inventory;
    private String location;

    public Inventory(String location) {
        this.location = location;
        inventory = new HashMap<String, Item>();
    }

    public void addItemToInventory(Item item) {
        inventory.put(item.getId(), item);
    }

    public Item getItem(String itemId) {
        return inventory.get(itemId);
    }

    public void removeItemFromInventory(Item item) {
        inventory.remove(item.getId());
    }

    public String getInventoryLocation() {
        return this.location;
    }

}
