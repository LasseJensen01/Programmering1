package E04;
import java.sql.SQLOutput;
import java.util.Scanner;
public class E04 {
    public static void main(String[] args) {
        System.out.println("Enter Investment amount in $, Annual interest rate & over how many years");
        Scanner scan1 = new Scanner(System.in);
        double investAmount = scan1.nextDouble();
        double interestRate = scan1.nextDouble();
        int years = scan1.nextInt();
        futureInvestmentValue(investAmount, interestRate, years);
        System.out.println("Dont do crypto kids");


    }

    public static double futureInvestmentValue(double investAmount, double interestRate, int years) {
        int count = 1;
        double total = investAmount;
        while (count <= years) {
            total += total * (interestRate / 100);
            System.out.println(total);
            count++;
        }
        return total;
    }
}
