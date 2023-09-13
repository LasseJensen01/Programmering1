package E10;

import java.util.Scanner;

public class E01B {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter numbers between 1 & 99. Finish up with 0");
        int sum = 0;
        int number = scan1.nextInt();

        while(number != 0 ){
            sum += number;
            System.out.print(sum + " ");
            number = scan1.nextInt();
        }
    }
}
