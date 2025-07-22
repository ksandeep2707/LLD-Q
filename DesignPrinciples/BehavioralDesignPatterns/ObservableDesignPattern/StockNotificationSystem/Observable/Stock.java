package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observable;

import java.util.*;
import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observer.Observer;


public class Stock implements Subject {
    private String name;
    private double price;
    private List<Observer> observers;

    public Stock(String name) {
        this.name = name;
        this.observers = new ArrayList<>();
    }

    public void setPrice(double price) {
        this.price = price;
        notifyObservers();
    }

    @Override
    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(name, price);
        }
    }
}