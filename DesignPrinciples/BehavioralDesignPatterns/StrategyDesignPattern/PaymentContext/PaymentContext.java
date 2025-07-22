package DesignPrinciples.StrategyDesignPattern.PaymentContext;

import DesignPrinciples.StrategyDesignPattern.PaymentStrategy.PaymentMethodInterface;

public class PaymentContext {
    PaymentMethodInterface paymentStrategy;
    
    public PaymentContext(PaymentMethodInterface paymentStrategy)
    {
      this.paymentStrategy=paymentStrategy;
    }

    public void pay(int amount){
        paymentStrategy.pay(amount);
    }
}
