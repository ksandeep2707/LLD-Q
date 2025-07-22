package DesignPrinciples.BehavioralDesignPatterns.ObservableDesignPattern.StockNotificationSystem.Observer;

public class SMSObserver implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("📲 SMS Alert: Stock " + stockName + " updated to " + price);
    }
}
