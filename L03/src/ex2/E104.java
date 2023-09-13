package ex2;
import java.util.Scanner;
public class E104 {
    public static void main (String[] args) {
        //Define loan amount
        System.out.println("Enter Loan Amount");
        Scanner scanner = new Scanner(System.in);
        double loanAmount = scanner.nextDouble();

        //Define annual interest rate
        System.out.println("Enter annual interest rate");
        Scanner scanner2 = new Scanner(System.in);
        double annualInterestRate = scanner2.nextDouble()/100;

        //Define number of years the payment spands
        System.out.println("Enter number of years");
        Scanner scanner3 = new Scanner(System.in);
        double time = scanner3.nextDouble();

        //Print of entered data
        System.out.printf("Loan Amount =%.2f\n", loanAmount);
        System.out.printf("Annual Interest =%.0f Percent\n", annualInterestRate);
        System.out.printf("Number of years =%.2f\n", time);

        //Calculate payment per month
        double monthlyRate = annualInterestRate/12.0;
        double numberOfMonths = time * 12;
        double denumerator = 1 - 1.0 / (Math.pow(1 + monthlyRate, numberOfMonths));
        //Space
        System.out.println();

        //Calculate and Print monthly payment
        double monthlyPayment = loanAmount * monthlyRate / denumerator;
        System.out.printf("Monthly Payment =%.2f\n", monthlyPayment);

        //Calculate and print total payment
        double totalPayment = numberOfMonths*monthlyPayment;
        System.out.printf("Total payemnt = %.2f",totalPayment);
    }
}
