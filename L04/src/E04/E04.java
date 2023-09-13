package E04;
import java.util.Scanner;
public class E04 {
    public static void  main(String[] args) {
        System.out.println("Enter you childs age");
        Scanner scanner1 = new Scanner(System.in);
        int age1 = scanner1.nextInt();
        String result = institution(age1);

        System.out.println("Is your child a boy?");
        boolean isBoy = scanner1.nextBoolean();
        String result2 = team(isBoy, age1);

        System.out.println("The institutaion is: " + result);
        System.out.println("Your child is assigned to: " + result2);
    }
    public static String institution(int age){
        if (age==0){
            return "Home";
        }
        else if (age==1||age==2){
            return "Nursery";
        }
        else if (age>=3 && age<=5){
            return "Kindergarten";
        }
        else if (age>=6 && age <=16){
            return "School";
        }
        else if (age>=17){
            return "Out of School";
        }
        else{
            return "Invalid input";
        }
    }

    public static String team (boolean isBoy, int age){
    if (isBoy == false && age<8){
        return "Tumbling Girls";
    }
    else if (isBoy == false && age>=8){
        return "Springy Girls";
    }
    else if (isBoy == true && age<8){
        return "Young Cubs";
    }
    else if (isBoy == true && age>=8){
        return "Cool Boys";
    }
    else{
        return "Invalid input";
    }
    }
}