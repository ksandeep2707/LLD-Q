package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observer;

import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observable.InvestementPlatformInterface;

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
