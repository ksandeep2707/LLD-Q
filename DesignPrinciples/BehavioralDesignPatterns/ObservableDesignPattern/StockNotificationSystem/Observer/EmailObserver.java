package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observer;

public class EmailObserver implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("📩 Email Alert: Stock " + stockName + " updated to " + price);
    }
}
