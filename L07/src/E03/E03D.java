package E03;
import  java.util.Scanner;
public class E03D {
    public static void main(String[] args){
        Scanner scan1 = new Scanner(System.in);
        System.out.println("Enter two numbers");
        int a = scan1.nextInt();
        int b = scan1.nextInt();
        System.out.println(sumEvenInts(a, b));
    }
    public static int sumEvenInts(int a,int b){
        int sum = 0;
        int c = 0;
        c = b - a;
        for (int i = 0; i <= c; i++){
            if ( a%2 == 0){
                sum += a;
            }
            a++;
        }
        return sum;
    }
}
