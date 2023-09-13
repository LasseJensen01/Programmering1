package E04;

import java.util.Scanner;

public class E04B {
    public static void main(String[] args){
        System.out.println("Enter sales amount");
        Scanner scan1 = new Scanner(System.in);
        double amount = scan1.nextDouble();
        System.out.println(finApp(amount));
    }
    public static double finApp(double amount){
        double sum = 0;
        if (amount <= 5000){
            sum = amount*0.06;
            return sum;
        }
        else if (amount <= 10000){
            sum = (amount-5000)*0.08+300;
            return sum;
        }
        else{
            sum = (amount-10000)*0.10+700;
            return sum;
        }
    }
}
