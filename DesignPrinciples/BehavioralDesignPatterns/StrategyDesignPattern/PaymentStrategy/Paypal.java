package DesignPrinciples.StrategyDesignPattern.PaymentStrategy;

public class Paypal implements PaymentMethodInterface{
    private String Name;
    private String paypalId;

    public Paypal(String Name,String paypalId){
        this.Name=Name;
        this.paypalId=paypalId;
    }
    
    @Override
    public void pay(int amount)
    {
        System.out.println("Congrat! You have successfully paid Rs. "+amount+" using paypal  with paypal id "+this.paypalId);   
    }
}
