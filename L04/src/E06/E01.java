package E06;
import java.util.Scanner;

public class E01 {
    public static void main (String[] args) {
        System.out.println("Enter the first number");
        Scanner scanner1 = new Scanner(System.in);
        int num1= scanner1.nextInt();
        String result = sign(num1);
        System.out.println(result);

    }
    public static String sign(int num1){
        if (num1>0){
            return "Positiv";
        }
        else if (num1<0){
            return "Negativ";
        }
        else{
            return "Number equals 0";
        }
    }
}
