package DesignPrinciples.ObservableDesignPattern.Observable;

import DesignPrinciples.ObservableDesignPattern.Observer.StockObserverInterface;

public interface InvestementPlatformInterface {
     public void addObserver(StockObserverInterface obr);
     public void removeObserver(StockObserverInterface obr);
     public void notifyObservers();
     public void setData(int newStockPrice);
     public int getData();

}
