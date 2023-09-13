package E04;
import java.util.Scanner;
public class E04C {
    public static void main(String[] args) {
        int amount = 10000;
        int i = 5000;
        int sum = 900;
        System.out.println("Sales    Commisions");
        while (amount <= 100000 ) {
            System.out.println(amount + "    " + sum);
            amount += 5000;
            sum += 500;
        }
    }
}