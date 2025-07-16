public class OpenForExtensionClosedForModification {
    public static void main(String[] args) {
        //Solution 1:
        InvoiceDAO1 d1=new InvoiceDAO1();
        d1.saveToDB();
        d1.saveToFile();
        //Solution 2:
        InvoiceDAOInterface dataBase=new DatabaseDAO();
        InvoiceDAOInterface file=new FIleDAO();
        dataBase.save();
        file.save();
    }
}


//Problem
class InvoiceDAO{
    public void saveToDB()
    {
        //logic to save it to DB
        System.out.println("Save to DB");
    }
}
 
//Requirement now you want to save tour invoice to File as well
//Problematic Solution: (Modifying it in the existing class)
class InvoiceDAO1{
    public void saveToDB()
    {
        //logic to save it to DB
        System.out.println("Save to DB");
    }
    public void saveToFile()
    {
        //logic to save data to file
        System.out.println("Saved to File...");
    }
}

//Solution 2: using open for extension closed for modificaiton principle
interface InvoiceDAOInterface{
    public void save();
}

class DatabaseDAO implements InvoiceDAOInterface{
    @Override
    public void save(){
        //logic to save it to database
        System.out.println("Saved to DB successfully");
    }
}

class FIleDAO implements InvoiceDAOInterface{
    @Override
    public void save()
    {
        //Logic to save it to file
        System.out.println("Saved to the file....");
    }
}

