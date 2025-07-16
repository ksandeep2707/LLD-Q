package DesignPrinciples.ObservableDesignPattern.Observer;

import DesignPrinciples.ObservableDesignPattern.Observable.InvestementPlatformInterface;

public class SMSAlert implements StockObserverInterface {
    InvestementPlatformInterface observable;

    public SMSAlert(InvestementPlatformInterface observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("SMS Alert: New Stock Price is " + observable.getData());
    }
}
