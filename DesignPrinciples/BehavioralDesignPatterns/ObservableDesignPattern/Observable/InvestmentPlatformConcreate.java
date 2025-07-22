package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observable;

import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observer.*;
import java.util.*;

public class InvestmentPlatformConcreate implements InvestementPlatformInterface {
    private int stockPrice;
    private List<StockObserverInterface> observers;

    public InvestmentPlatformConcreate() {
        stockPrice = 0;
        observers = new ArrayList<>();
    }

    @Override
    public void addObserver(StockObserverInterface obj) {
        observers.add(obj);
    }

    @Override
    public void removeObserver(StockObserverInterface obj) {
        observers.remove(obj);
    }

    @Override
    public void notifyObservers() {
        for (StockObserverInterface obr : observers) {
            obr.update();
        }
    }

    @Override
    public void setData(int newStockPrice) {
        this.stockPrice = newStockPrice;
        notifyObservers();
        ;
    }

    @Override
    public int getData() {
        return this.stockPrice;
    }

}
