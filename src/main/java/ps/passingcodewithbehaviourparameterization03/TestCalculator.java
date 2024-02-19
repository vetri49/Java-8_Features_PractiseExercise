package ps.passingcodewithbehaviourparameterization03;

//IntegerMath interface with an abstract method operation on two numbers
 interface IntegerMath {
 int operation(int a, int b);
}

class Calculator {
 public int operationBinary(int a, int b, IntegerMath op) {
     return op.operation(a, b);
 }
}

public class TestCalculator {
 public static void main(String[] args) {
     
     Calculator calculator = new Calculator();

     IntegerMath addition = (a, b) -> {
         System.out.println("Addition is: " + (a + b));
         return a + b;
     };

     IntegerMath subtraction = (a, b) -> {
         System.out.println("Subtraction is: " + (a - b));
         return a - b;
     };

     IntegerMath multiplication = (a, b) -> {
         System.out.println("Multiplication is: " + (a * b));
         return a * b;
     };

     IntegerMath division = (a, b) -> {
         System.out.println("Division is: " + (a / b));
         return a / b;
     };

     
     calculator.operationBinary(20, 10, addition);
     calculator.operationBinary(30, 20, subtraction);
     calculator.operationBinary(10, 20, multiplication);
     calculator.operationBinary(10, 5, division);
 }
}

