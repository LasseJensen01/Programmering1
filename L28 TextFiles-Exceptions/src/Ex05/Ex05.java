package Ex05;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Ex05 {
    public static void main(String[] args) {
        String filename = "L28 TextFiles-Exceptions/src/Ex05/TextFile";
        String filename2 = "L28 TextFiles-Exceptions/src/Ex05/TextFile2500";
        System.out.println(max(filename));
        System.out.println(min(filename));
        try {
            System.out.println(gennemsnit(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int max(String filename){
        int max = 0;
        try (Scanner scanner = new Scanner(new File(filename))){
            int temp = 0;
            while (scanner.hasNextInt()){
                temp = scanner.nextInt();
                if (temp > max){
                    max = temp;
                }
            }
        }
        catch (Exception ex){
            System.err.println("Uhoh poopie");
        }
        return max;
    }

    public static int min(String filename){
        int min = 9999;
        try (Scanner scanner = new Scanner(new File(filename))){
            int temp = 0;
            while (scanner.hasNextInt()){
                temp = scanner.nextInt();
                if (temp < min){
                    min = temp;
                }
            }
        }
        catch (Exception ex){
            System.err.println("Uhoh poopie");
        }
        return min;
    }

    public static double gennemsnit(String filename) throws IOException {
        int total = 0;
        int average = 0;
        int i = 1;
        try (Scanner scanner = new Scanner(new File(filename))){
            for (i = 1; scanner.hasNextInt(); i++){
                total += scanner.nextInt();
            }
            average = total/i;
        }
        catch (FileNotFoundException ex){
            System.err.println("Uhoh poopie");
        }
        return average;
    }
}
