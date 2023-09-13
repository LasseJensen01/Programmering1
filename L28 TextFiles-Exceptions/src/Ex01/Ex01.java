package Ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        System.out.println("User Directory = " + System.getProperty("user.dir"));

        File in = new File("L28 TextFiles-Exceptions/src/Ex01/Textfile");

        try (Scanner scanner = new Scanner(in)){
            while (scanner.hasNextInt()){
                int temp = scanner.nextInt();
                System.out.println(temp*2);
            }
        }
        catch (FileNotFoundException ex){
            System.err.println("Sorry! An unexpected error has occurred.");
            System.err.println("Technical message: " + ex.getMessage());
        }

        ArrayList<Integer> s = new ArrayList<>();
        try(Scanner scanner = new Scanner(in)){
            while(scanner.hasNextInt()){
                s.add(scanner.nextInt());
            }
            for (int i = 0; i < s.size(); i++){
                System.out.println(s.get(s.size()-1-i));
            }
        }
        catch (FileNotFoundException ex){
            System.err.println("Sorry! An unexpected error has occurred in try/catch 2");
            System.err.println("Technical message: " + ex.getMessage());
        }
    }
}
