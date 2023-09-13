package E10;
import java.util.Scanner;
public class E01 {
    public static void main(String[] args){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter numbers between 1 & 99. Finish up with 0");
        int largestNumber = 0;
        int lowestNumber = 99;
        int evenNumbers = 0;
        int oddNumbers = 0;
        int number = scan1.nextInt();

        while(number != 0){
            if (number%2 != 0 ){
                oddNumbers++;
            }
            else{
            evenNumbers++;
            }
            if (number > largestNumber){
                largestNumber = number;
            }
            if (number < lowestNumber){
                lowestNumber = number;
            }
            number = scan1.nextInt();
        }
        System.out.println("There are " + oddNumbers + " odd numbers and " + evenNumbers + " even numbers");
        System.out.println("The lowest number is " + lowestNumber + " and the higest number is " + largestNumber);
    }
}
