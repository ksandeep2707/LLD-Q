package DesignPrinciples.ObservableDesignPattern.Observer;

import DesignPrinciples.ObservableDesignPattern.Observable.InvestementPlatformInterface;

public class EmailAlert implements StockObserverInterface {
    InvestementPlatformInterface observable;

    public EmailAlert(InvestementPlatformInterface observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Email Alert: New Stock Price is " + observable.getData());
    }
}
