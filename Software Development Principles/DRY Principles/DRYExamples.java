public class DRYExamples {
    public static void main(String[] args) {
        //Case 1: Before DRY implementation.
        OrderProcessor od=new OrderProcessor();
        od.processOnlineOrder("Sandeep", 100);
        od.processInStoreOrder("Sandeep", 1000);

        //Case 2: After DRY Implementation
        OrderProcessorDRY odDry=new OrderProcessorDRY();
        odDry.processOnlineOrder("Sandeep", 100);
        odDry.processInStoreOrder("Sandeep", 1000);
    }
}

class OrderProcessor {
    public void processOnlineOrder(String customerName,double amount)
    {
          System.out.println("Processing Online Order for: "+customerName);
          double tax= 0.18*amount;
          double totalAmount=amount+tax;
          System.out.println("Customer: " + customerName);
          System.out.println("Tax: "+tax);
          System.out.println("Total Amount: "+totalAmount);
    }

    public void processInStoreOrder(String customerName,double amount)
    {
          System.out.println("Processing In Store Order for: "+customerName);
          double tax= 0.18*amount;
          double totalAmount=amount+tax;
          System.out.println("Customer: " + customerName);
          System.out.println("Tax: "+tax);
          System.out.println("Total Amount: "+totalAmount);
    }
}
// Problem: Code for tax and total calculation is duplicated. If tax rate changes, we must update in multiple places, risking inconsistency.

//Update Code:

class OrderProcessorDRY{
    private void printInvoice(String customerName,double amount){
          double tax= calculateTax(amount);
          double totalAmount=amount+tax;
          System.out.println("Customer: " + customerName);
          System.out.println("Tax: "+tax);
          System.out.println("Total Amount: "+totalAmount);
    }
    private double calculateTax(double amount)
    {
        return 0.18*amount;
    } 

    public void processOnlineOrder(String customerName,double amount)
    {
          System.out.println("Processing Online Order for: "+customerName);
          printInvoice(customerName, amount);

    }

    public void processInStoreOrder(String customerName,double amount)
    {
          System.out.println("Processing In Store Order for: "+customerName);
          printInvoice(customerName, amount);
    }

}
