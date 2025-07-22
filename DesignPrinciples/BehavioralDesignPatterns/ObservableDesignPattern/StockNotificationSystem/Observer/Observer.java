package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observer;

public interface Observer {
    void update(String stockName, double price);
}
