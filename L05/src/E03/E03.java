package E03;
import java.util.Scanner;
public class E03 {
    public static void main(String[] args) {
        System.out.println("Enter a number");
        Scanner scan1 = new Scanner(System.in);
        int num1 = scan1.nextInt();
        System.out.println(sumDigits(num1));

    }

    public static int sumDigits(int n){
        int sum = 0;
        int tempSum = 0;
        while (n != 0){
            tempSum = n%10;
            if (tempSum%2==1){
                sum += tempSum;
            }
            n = n/10;
        }
        return sum;
    }
}

