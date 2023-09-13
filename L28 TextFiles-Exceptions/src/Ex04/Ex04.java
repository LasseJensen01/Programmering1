package Ex04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ex04 {
    public static void main(String[] args) {
        File out = new File("L28 TextFiles-Exceptions/src/Ex04/TextFile");

        try(PrintWriter writer = new PrintWriter(out)) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write positive ints to type into txt file. End with a negative");
            boolean cont = true;
            while (cont){
                int temp = scanner.nextInt();
                if (temp > 0){
                    writer.println(temp);
                } else cont = false;
            }
        }
        catch (FileNotFoundException ex){
            System.out.println("Oppsie Doobsie");
            System.out.println("lookie here " + ex.getMessage());
        }
    }
}
