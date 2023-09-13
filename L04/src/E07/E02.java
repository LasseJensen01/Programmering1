package E07;
import java.util.Scanner;

public class E02 {
    public static void main(String[] args) {
        //Enter three numbers
        System.out.println("Enter three numbers");
        Scanner scanner1 = new Scanner(System.in);
        int num1 = scanner1.nextInt();
        int num2 = scanner1.nextInt();
        int num3 = scanner1.nextInt();
        String result = order(num1, num2, num3);
        System.out.println(result);
    }
        public static String order(int num1, int num2, int num3){
        //Register if the 3 numbers are acsending, decending or neither
        if (num1 < num2) {
            if (num2 < num3) {
                return "Tallende er Stigende";
            } else {
                return "Hverken eller";
            }
        }
        else if (num1 > num2) {
            if (num2 > num3) {
                return "Tallende er faldende";
            } else {
                return "Hverken eller";
            }
        }
        else {
            return "Hverken eller";
        }
        }
    }

