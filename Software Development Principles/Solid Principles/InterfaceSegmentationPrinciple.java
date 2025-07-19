
public class InterfaceSegmentationPrinciple {
    
}

//Code which doesnot follow this principle
interface ResturantEmployee{
     public void washDish();
     public void cook();
     public void serve();
     public void takeOrders();
}

class Waiter implements ResturantEmployee{
    @Override
    public void washDish()
    {
        //No implementation
    }
    @Override
    public void cook()
    {
        //Not his job wont implement it.
    }
    @Override
    public void serve()
    {
        System.out.println("Serving food to customer");
    }
    @Override
    public void takeOrders()
    {
        System.out.println("Taking orders from the customer");
    }
}


//Solution--Break the ResturantEmployee into sub interg=faces such that onlu the required implementaion should be implemented by te child.

interface WaiterInterface{
    public void serve();
    public void takeOrders();
}

interface chef{
    public void cook();
    public void washDish();
}


class Waiter1 implements WaiterInterface{
    @Override
    public void serve()
    {
        System.out.println("Serving to the customer"); 
    }
    @Override
    public void takeOrders()
    {
        System.out.println("Taking Orders from the customer"); 

    }
}

