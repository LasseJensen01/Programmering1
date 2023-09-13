package Ex02;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex02 {
    public static void main(String[] args) {
        String filename1 = "L33 Repetation Semesterproever/src/Ex02/filename1.txt";
        String filename2 = "L33 Repetation Semesterproever/src/Ex02/filename2.txt";
        String filenameNy = "L33 Repetation Semesterproever/src/Ex02/filenameNy.txt";
        fuck(filename1,filename2,filenameNy);
        File fil = new File(filenameNy);
        try(PrintWriter writer = new PrintWriter(fil)){
            writer.println("Test");
        }catch(Exception ex){
            System.out.println("Fuck");
        }
    }

    public static void fuck(String fileName1, String fileName2, String fileNameNy){
        File fil1 = new File(fileName1);
        File fil2 = new File(fileName2);
        File filNy = new File(fileNameNy);
        try (Scanner scanner1 = new Scanner(fil1);
             Scanner scanner2 = new Scanner(fil2);
             PrintWriter writer = new PrintWriter(filNy)){

            int number1 = scanner1.nextInt();
            int number2 = scanner2.nextInt();
            while (!scanner1.hasNextInt(Integer.MAX_VALUE) || !scanner2.hasNextInt(Integer.MAX_VALUE) ){
                System.out.println("fuck");
                if (number1 < number2){
                    System.out.println("fuck");
                    writer.print(number1);
                    number1 = scanner1.nextInt();
                } else {
                    writer.print(number2);
                    number2 = scanner2.nextInt();
                }
            }
            while (!scanner1.hasNextInt(Integer.MAX_VALUE)){
                number1 = scanner1.nextInt();
                writer.println(number1);
            }
            while (!scanner2.hasNextInt(Integer.MAX_VALUE)){
                number2 = scanner2.nextInt();
                writer.println(number2);
            }
        }catch (Exception ex){
            System.out.println("Fuck");
        }
    }
}
