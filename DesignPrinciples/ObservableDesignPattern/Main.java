package DesignPrinciples.ObservableDesignPattern;

import DesignPrinciples.ObservableDesignPattern.Observable.InvestementPlatformInterface;
import DesignPrinciples.ObservableDesignPattern.Observable.InvestmentPlatformConcreate;
import DesignPrinciples.ObservableDesignPattern.Observer.EmailAlert;
import DesignPrinciples.ObservableDesignPattern.Observer.SMSAlert;
import DesignPrinciples.ObservableDesignPattern.Observer.StockObserverInterface;

public class Main {
    public static void main(String[] args) {
        //Observable/Observer Design Pattern
        InvestementPlatformInterface observable=new InvestmentPlatformConcreate();
        StockObserverInterface observer1=new EmailAlert(observable);
        StockObserverInterface observer2=new SMSAlert(observable);

        //Adding observers to the observable
        observable.addObserver(observer1);
        observable.addObserver(observer2);

        //Updating the current price;
        observable.setData(500);

        //Removing observer
        observable.removeObserver(observer2);

        observable.setData(400);
    }
}
