public class SingleResponsiblityPrinciple{
    public static void main(String[] args) {
         //Code without using single responsibility principle
         ReportController rc=new ReportController();
         rc.generateReport();
         rc.saveReportToDB();
         rc.printReport();
         //Code using single responsiblity principle
         Report rt=new Report();
         rt.generateReport();
         ReportDAO rdao=new ReportDAO(rt);
         rdao.saveReportToDB();
         ReportPrinter rp=new ReportPrinter(rt);
         rp.printReport();
    }
 }

//Problem 1:
//Ex:Report
class ReportController{
    public void generateReport()
    {
        //Logic to generate Report
        System.out.println("Report Generation Done......");
    }
    public void saveReportToDB()
    {
      //Logic to save the Report to the DB
      System.out.println("Report successfully saved to DB...");
    }
    public void printReport()
    {
        //Logic to print the report
        System.out.println("Report generated successfully");
    }

}
//Problem: It has 3 reason to change(generateReport,saveReportToDb,printReport) .If any change in the one of the 3 function happen then ie will change the whole class.


//Solution:
//Break the class into subclasses such that each class is having single responsibilities.

//Class1: Report
class Report{
    public void generateReport()
    {
        //Logic to generate Report
        System.out.println("Report Generated...");
    }
}
//Report Class has only sinlge reason to change i.e. generateReport

//Class2: ReportDAO
class ReportDAO{
    Report report;
    public ReportDAO(Report report)
    {
        this.report=report;
    }
    public void saveReportToDB()
    {
        //Logic to save report to DB.
        System.out.println("Saved to DB....");
    }
}
//ReportDAO class has single reasont to change i.e saveReportToDB

//class3: ReportPrinter
class ReportPrinter{
    Report report;
    public ReportPrinter(Report report)
    {
       this.report=report;
    }

    public void printReport()
    {
        //Logic to print Report
        System.out.println("Printed Report....");
    }
}
//ReportPrinter class has single reason to change i.e printReport.


