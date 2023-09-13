package Ex03;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        File out = new File("L28 TextFiles-Exceptions/src/Ex03/TextFile");
        try(PrintWriter writer = new PrintWriter(out)){
            int temp = 100;
            while (temp > 0){
                if (temp%2 != 0){
                    writer.println(temp);
                }
                temp--;
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("File not found... kinda cringe ngl");
            System.out.println("Figure out why here is the error " + ex.getMessage());
        }
        try (Scanner scanner = new Scanner(out);){
            while (scanner.hasNextInt()){
                System.out.println(scanner.nextInt());
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("File not found... kinda cringe ngl");
            System.out.println("Figure out why here is the error " + ex.getMessage());
        }
    }
}
