package E05;
import java.util.Scanner;
import java.util.Arrays;
public class E05B {
    public static void main(String[] args){
        int[] output = new int[50];
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter the amount of numbers you would like to enter");
        int maxNumber = scan1.nextInt();
        int[] a = new int[maxNumber];
        System.out.println("Enter numbers between 1 - 49");
        for(int i = 0; i < a.length; i++){
            int temp = scan1.nextInt();
            if (temp < 1 || temp > 49){
                System.out.println("Invalid Input");
                
            }
            else{
                a[i] = temp;
            }
        }
        for(int n : a ){
            output[n] += 1;
        }
        for (int i = 0; i < output.length; i++){
            if (output[i] > 1){
                System.out.println(i + " has occured " + output[i] + " times");
            }
            else if (output[i] == 1){
                System.out.println(i + " has occured " + output[i] + " time");
            }
        }
    }
}
