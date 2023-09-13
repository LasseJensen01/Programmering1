package E02;
import java.util.Scanner;
public class E02 {
    public static void main(String[] args) {
        //Enter three numbers
        System.out.println("Enter three numbers");
        Scanner scanner1 = new Scanner(System.in);
        int num1 = scanner1.nextInt();
        int num2 = scanner1.nextInt();
        int num3 = scanner1.nextInt();

        //Register if the 3 numbers are acsending, decending or neither
        if (num1 < num2) {
            if (num2 < num3) {
                System.out.println("Tallende er Stigende");
            } else {
                System.out.println("Hverken eller");
            }
        }
        else if (num1 > num2) {
            if (num2 > num3) {
                System.out.println("Tallende er faldende");
            } else {
                System.out.println("Hverken eller");
            }
        }
        else {
            System.out.println("Hverken eller");
        }
    }
}

