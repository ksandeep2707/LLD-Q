import java.util.ArrayList;
import java.util.*;
public class LiskovSubstitutionPrinciple {
  public static void main(String[] args) {
       //Problem
   List<TwoWheeler> vehicle=new ArrayList<TwoWheeler>();
   vehicle.add(new Bike());
   vehicle.add(new Bicycle());
   
   for(TwoWheeler v:vehicle)
     v.getAvgSpeed();

   for(TwoWheeler v:vehicle)
     v.hasEngine(); 
  }  
}

interface TwoWheeler{
    public Boolean hasEngine();
    public int getAvgSpeed();
}

class Bike implements TwoWheeler{
    @Override
    public Boolean hasEngine()
    {
        System.out.println("Is has Engine");
        return true;
    }
    @Override
    public int  getAvgSpeed()
    {
        System.out.println("Avg Speed is "+55);
        return 55;
    }
}

class Bicycle implements TwoWheeler{
    @Override
    public Boolean hasEngine()
    {
        throw new AssertionError("Bicycle doesnot have Engine");
    }
    @Override
    public int getAvgSpeed(){
        System.out.println("Avg Speed is "+10);
        return 10;
    }
}
