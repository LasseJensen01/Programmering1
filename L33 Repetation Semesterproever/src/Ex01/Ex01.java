package Ex01;

import java.io.File;
import java.util.Scanner;

public class Ex01 {
    public static void main(String[] args) {
        String fil = "L33 Repetation Semesterproever/src/Ex01/personer.txt";
        System.out.println(linFileSearchPerson(fil,"Hansen"));
    }
    public static String linFileSearchPerson(String fileName, String target){
        File fil = new File(fileName);
        boolean NotFound = true;
        String nameFound = "";
        try (Scanner scanner = new Scanner(fil)){
            while (NotFound && scanner.hasNextLine()){
                String name = scanner.nextLine();
                int idx = name.lastIndexOf(' ');
                String lastName = name.substring(idx+1);
                if (lastName.equals(target)){
                    nameFound = name;
                    NotFound = false;
                }
            }
        } catch (Exception ex){
            System.err.println("Fuck");
        }
        return nameFound;
    }
}
