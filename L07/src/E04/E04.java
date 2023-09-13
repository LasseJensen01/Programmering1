package E04;

import java.awt.desktop.SystemSleepEvent;
import java.util.Scanner;

public class E04 {
    public static void main(String[] args){
        Scanner scan1 = new Scanner(System.in);
        int a = 0;
        int largestNumber = 0;
        int lowestNumber = 99;
        int oddNumbers = 0;
        int evenNumbers = 0;
        System.out.println("Enter how many numbers you would like to use");
        int c = scan1.nextInt();
        System.out.println("Enter the numbers you would like to process");
        for (int i = 1; i <= c; i++){
            a = scan1.nextInt();
            if (a > largestNumber){
                largestNumber = a;
            }
            if (a < lowestNumber){
                lowestNumber = a;
            }
            if (a%2 == 0){
                evenNumbers++;
            }
            else{
                oddNumbers++;
            }
        }
        System.out.println("The largestnumber is " + largestNumber + " the lowest number is " + lowestNumber);
        System.out.println("There are " + evenNumbers + " even number and " + oddNumbers + " odd numbers");
    }
}
