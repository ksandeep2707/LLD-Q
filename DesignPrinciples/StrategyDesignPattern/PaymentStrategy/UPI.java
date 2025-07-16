package DesignPrinciples.StrategyDesignPattern.PaymentStrategy;

public class UPI implements PaymentMethodInterface{
    private String upiId;
    private String Name;

    public UPI(String upiId,String Name)
    {
        this.upiId=upiId;
        this.Name=Name;
    }

    @Override
    public void pay(int amount)
    {
        System.out.println("Congrat! You have successfully paid Rs. "+amount+" using UPI with UPI ID "+this.upiId);   
    }
}
