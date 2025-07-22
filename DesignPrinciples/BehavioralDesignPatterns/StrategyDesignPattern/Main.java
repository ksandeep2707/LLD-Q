package DesignPrinciples.StrategyDesignPattern;

import java.time.LocalDate;
import java.util.Scanner;
import DesignPrinciples.StrategyDesignPattern.PaymentContext.PaymentContext;
import DesignPrinciples.StrategyDesignPattern.PaymentStrategy.*;

class PaymentExecption extends Exception{
    PaymentExecption(String message)
    {
        super(message);
    }
}

public class Main{
    public static void main(String[] args) throws PaymentExecption {
        PaymentContext payment;
        Scanner sc=new Scanner(System.in);
        System.out.println("Your Total Amount: 100.\n");
        System.out.println("Please Select Payment Method.");
        System.out.println("1.Credit Cart.\n2.UPI.\n3.Paypal.\n");
        int option=sc.nextInt();
        switch (option) {
            case 1:
                payment=new PaymentContext(new CreditCard("Sandeep Kumar","399",LocalDate.now(),"123456778"));
                break;
            case 2:
                payment=new PaymentContext(new UPI("ksand@gpay","Sandeep Kumar"));
                break;
            case 3:
                payment=new PaymentContext(new Paypal("Sandeep Kumar","sand@paypal"));
                break;
        
            default:
                throw new PaymentExecption("Incorrect Option Selected");
        }
        payment.pay(100);
        System.out.println("You have successfully Paid. Dont forget to shop again....");

    }
}