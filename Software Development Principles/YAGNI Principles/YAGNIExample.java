
public class YAGNIExample {

   public static void main(String[] args) {
     //Case: YAGNI Violation
      ReportGenerator rg=new ReportGenerator();
      rg.generateReport("PDF");

      //Case: YAGNI Implementation
      ReportGeneratorYAGNI yagniRg=new ReportGeneratorYAGNI();
      yagniRg.generatePDFReport();     
   }

}


//As of now Requirement is only to Generate PDF

class ReportGenerator {
    public void generateReport(String type) {
        if (type.equals("PDF")) {
            // generate PDF
            System.out.println("generate PDF");
        } else if (type.equals("Excel")) {
            // generate Excel
            System.out.println("generate Excel");

        } else if (type.equals("HTML")) {
            // generate HTML
            System.out.println("generate HTML");

        }
    }
}

//Problem: Only PDF is needed now, but other formats were added "just in case". Extra code = extra complexity and testing.

//Update Code:

class ReportGeneratorYAGNI {
    public void generatePDFReport() {
        // generate PDF
        System.out.println("generate PDF");
    }
}

//Adv: Clean and focused. Other formats can be added later when needed.