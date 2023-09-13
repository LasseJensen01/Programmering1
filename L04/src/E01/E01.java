package E01;
import java.util.Scanner;

public class E01 {
    public static void main (String[] args) {
        System.out.println("Enter the first number");
        Scanner scanner1 = new Scanner(System.in);
        double num1= scanner1.nextDouble();
        if (num1>0){
            System.out.println("Positiv");
        }
        else if (num1<0){
            System.out.println("Negativ");
        }
        else{
            System.out.println("Number equals 0");
        }
    }
}
