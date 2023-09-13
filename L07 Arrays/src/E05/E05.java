package E05;
import java.util.Scanner;
import java.util.Arrays;
public class E05 {
    public static void main(String[] args){
        int[] a = new int[10];
        int evenNumbers = 0;
        int oddNumbers = 0;
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter 10 numbers");
        for(int i = 0; i < a.length; i++){
            a[i] = scan1.nextInt();
            if (a[i]%2 == 0){
                evenNumbers++;
        }
            else{
                oddNumbers++;
            }
        }
        System.out.println("Array for a = " + Arrays.toString(a));
        System.out.println("There are " + evenNumbers + " even numbers and " + oddNumbers + " odd numbers");
    }
}
