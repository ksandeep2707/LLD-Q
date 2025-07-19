public class KISSExamples {
    public static void main(String[] args) {
        //Case 1: Before KISS Principles Implementation
        Calculator cal=new Calculator();
        System.out.println("Addition of 3 and 4 :"+cal.operate("add", 3, 4));
        System.out.println("Multipication of 3 and 4 :"+cal.operate("multiply", 3, 4));

        //Case 1: Before KISS Principles Implementation
        SimpleCalculator simplecal=new SimpleCalculator();
        System.out.println("Addition of 3 and 4 :"+simplecal.add(3,4));
        System.out.println("Multipication of 3 and 4 :"+simplecal.multiply(3, 4));

    }
}

class Calculator {
    public int operate(String operation, int a, int b) {
        if (operation.equals("add")) {
            return a + b;
        } else if (operation.equals("subtract")) {
            return a - b;
        } else if (operation.equals("multiply")) {
            return a * b;
        } else if (operation.equals("divide")) {
            if (b == 0) throw new ArithmeticException("Cannot divide by zero");
            return a / b;
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }
}

//Problem: This tries to do too much in one method. Harder to extend or test individual operations.

//Updated Code:

class SimpleCalculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}


