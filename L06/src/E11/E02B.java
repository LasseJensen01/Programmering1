package E11;

import java.util.Scanner;

public class E02B {
    public static void main(String[] args) {
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter numbers between 1 & 99. Finish up with 0");
        int prevNumber = 0;
        int count = 0;
        int number = scan1.nextInt();
        boolean hasPrinted = false;
        while (number != 0) {
             if (number == prevNumber && !hasPrinted){
                 hasPrinted = true;
                System.out.print(number + " ");
            }
             else{
                 hasPrinted = false;
             }
            prevNumber = number;
            number = scan1.nextInt();
        }
    }
}
