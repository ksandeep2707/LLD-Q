package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign;

public class Main {
    public static void main(String[] args) {
         VendingMachine vm=new VendingMachine();
         // Add Items
         vm.getInventory().addItemToInventory(new Item("COKE", 10));
         vm.getInventory().addItemToInventory(new Item("PEPSI", 20));
         vm.getInventory().addItemToInventory(new Item("CHIPS", 5));
         vm.getInventory().addItemToInventory(new Item("TOFFEE", 1));



         //CLick Insert Coin Button
         vm.getCurrentState().clickOnInsertCoin();
         //Insert Coin
         vm.getCurrentState().insertCoin(Coin.DIME);
         vm.getCurrentState().insertCoin(Coin.NICKEL);
         vm.getCurrentState().insertCoin(Coin.PENNY);
         vm.getCurrentState().insertCoin(Coin.PENNY);
         //Click select Product Button
         vm.getCurrentState().clickSelectProductButton();
         //Select item
         vm.getCurrentState().selectProduct("COKE");
         //Click Dispense
         vm.getCurrentState().clickProductDispenseProduct();
        

    }
}
