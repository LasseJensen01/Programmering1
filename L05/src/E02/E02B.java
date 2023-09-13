package E02;
import java.util.Scanner;
public class E02B {
    public static void main(String[] args) {
        System.out.println("Enter the two numbers");
        Scanner scan1 = new Scanner(System.in);
        int num1 = scan1.nextInt();
        int num2 = scan1.nextInt();
        System.out.println(sumEventsInts(num1, num2));
    }

    public static int sumEventsInts(int a, int b) {
        int sum = 0;
        while (a <= b) {
            if (a % 2 == 0) {
                sum += a;
            }
            a++;
        }
        return sum;
    }
}