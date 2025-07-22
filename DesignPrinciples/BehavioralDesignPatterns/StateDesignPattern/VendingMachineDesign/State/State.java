package DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.State;

import DesignPrinciples.BehavioralDesignPatterns.StateDesignPattern.VendingMachineDesign.Coin;

public interface State {

    public void clickOnInsertCoin();

    public void insertCoin(Coin coin);

    public void clickSelectProductButton();

    public void selectProduct(String itemid);

    public void clickProductDispenseProduct();

    public void dispenseProduct(String itemid);

    public void getRefund(int price);

    public void clickCancel();
}
