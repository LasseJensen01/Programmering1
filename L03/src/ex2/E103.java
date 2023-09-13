package ex2;
import java.util.Scanner;
public class E103 {
    // Loan Assignement
    public static void main (String[] args){
        double tax=0.06;
        System.out.println("Enter sales amount");
        Scanner scanner = new Scanner(System.in);
        double salesAmount = scanner.nextDouble();
        double salesTax = salesAmount*tax;
        System.out.printf("Sales Tax =\n %.2f",salesTax);
    }
}
