package E11;

import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter numbers between 1 & 99. Finish up with 0");
        int max = 0;
        int count = 0;
        int number = scan1.nextInt();
        while (number != 0){
            if (number > max){
                max = number;
                count = 1;
            }
            else if (max == number){
                count++;
            }
            number = scan1.nextInt();
        }
        System.out.println("The max number is " + max + " and it occurs " + count + " times");
    }
}
