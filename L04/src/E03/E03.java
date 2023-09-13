package E03;
import java.util.Random;
import java.util.Scanner;
public class E03 {
    public static void main(String[] args) {
        System.out.println("Enter your guess");
        Scanner scanner1 = new Scanner(System.in);
        int num1 = scanner1.nextInt();

        int digit1 = num1/10;
        int digit2 = num1%10;
        String reversedNumString1 = String.valueOf(digit2)+String.valueOf(digit1);
        int reversedNum1 = Integer.parseInt(reversedNumString1);

        int max = 99;
        int min = 10;
        int range = max-min+1;
        int randomNum = (int)(Math.random()*range)+min;
        int randDigit1 = randomNum/10;
        int randDigit2 = randomNum%10;
        System.out.printf("Lottery number is %d\n",randomNum);

        if (num1==randomNum){
            System.out.println("You win $10.000");
        }
        else if (reversedNum1==randomNum){
            System.out.println("Your win $3.000");
        }
        else if (digit1 == randDigit1 || digit1 == randDigit2 || digit2 == randDigit1 || digit2 == randDigit2){
            System.out.println("You win $1.000");
        }
        else{
            System.out.println("You lose");
        }
    }
}
