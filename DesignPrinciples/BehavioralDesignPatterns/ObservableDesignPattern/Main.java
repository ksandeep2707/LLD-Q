package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern;
//the package statement at the top of a Java class defines which package the class belongs to

import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observable.InvestementPlatformInterface;
import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observable.InvestmentPlatformConcreate;
import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observer.EmailAlert;
import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observer.SMSAlert;
import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.Observer.StockObserverInterface;

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
