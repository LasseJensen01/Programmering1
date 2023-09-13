package E08;
import java.util.Scanner;
public class E08 {
    public static void main(String[] args){
        System.out.println("Enter day and month");
        Scanner scan1 = new Scanner(System.in);
        int date = scan1.nextInt();
        int month = scan1.nextInt();
        String result = season(date,month);
        System.out.println(result);
    }
    public static String season(int date, int month){
        if (date > 31 || month > 12 || date < 0 || month < 0){
            return "Invalid Input";
        }
        if (month == 12 || month == 1 || month ==2 && date<21){
            return "Vinter";
        }
        else if (month == 2 && date>=21 || month == 3 || month == 4 || month ==5 && date<21){
            return "Forår";
        }
        else if (month == 5 && date >= 21 ||month == 6 || month == 7 || month == 8 && date<21){
            return "Sommer";
        }
        else{
            return "Efterår";
        }
    }

}
