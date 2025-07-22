package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observable;

import DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observer.Observer;

interface Subject {
    void subscribe(Observer observer);
    void unsubscribe(Observer observer);
    void notifyObservers();
}
