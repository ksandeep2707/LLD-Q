package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem;

import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observable.Stock;
import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observer.*;



public class StockAlertSystem {
    public static void main(String[] args) {
        System.out.println("Test Case 1: Single Observer Subscription");
        Stock appleStock = new Stock("AAPL");
        Observer emailObserver1 = new EmailObserver();
        appleStock.subscribe(emailObserver1);
        appleStock.setPrice(150.0);
        System.out.println();

        System.out.println("Test Case 2: Multiple Observers for the Same Stock");
        Stock teslaStock = new Stock("TSLA");
        Observer emailObserver2 = new EmailObserver();
        Observer smsObserver1 = new SMSObserver();
        teslaStock.subscribe(emailObserver2);
        teslaStock.subscribe(smsObserver1);
        teslaStock.setPrice(720.5);
        System.out.println();

        System.out.println("Test Case 3: Unsubscribing an Observer");
        Stock googleStock = new Stock("GOOGL");
        Observer emailObserver3 = new EmailObserver();
        Observer smsObserver2 = new SMSObserver();
        googleStock.subscribe(emailObserver3);
        googleStock.subscribe(smsObserver2);
        googleStock.unsubscribe(smsObserver2);
        googleStock.setPrice(2800.0);
        System.out.println();
    }
}

