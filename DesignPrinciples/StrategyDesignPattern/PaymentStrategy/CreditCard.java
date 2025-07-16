package DesignPrinciples.StrategyDesignPattern.PaymentStrategy;

import java.time.LocalDate;

public class CreditCard implements PaymentMethodInterface{
    private String Name;
    private String cvv;
    private LocalDate expiryDate;
    //LocalDate currentDate=LocalDate.now();
    //LocalDate date=LocalDate.of(2023, 0, 2);
    //LocalDate parseDate=LocalDate.parse("2023/01/02");
    private String cardNo;
    
    public CreditCard(String Name,String cvv,LocalDate expiryDate,String cardNo)
    {
     this.Name=Name;
     this.cvv=cvv;
     this.expiryDate=expiryDate;
     this.cardNo=cardNo;
    }

    @Override
    public void pay(int amount)
    {
        System.out.println("Congrat! You have successfully paid Rs. "+amount+" using credit card with card nu "+this.cardNo);   
    }
}
