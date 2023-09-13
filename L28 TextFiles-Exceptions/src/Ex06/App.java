package Ex06;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        tryCatchIsBetter();
        ifElseIsBetter();

    }


    public static void tryCatchIsBetter() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        try (Scanner scanner = new Scanner(System.in)) {
            int index = -1;
            while (index < 0 || index > 9) {
                System.out.println("Type in an index (0..9): ");
                index = scanner.nextInt();
                System.out.printf("Prime at index %d is %d", index, primes[index]);
            }
        } catch (Exception ex) {
            System.err.println("Index was not an int between 0..9");
        }
    }

    public static void ifElseIsBetter() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        Scanner scanner = new Scanner(System.in);
        int index = -1;
        while (index < 0 || index > 9) {
            System.out.println("Type in an index (0..9): ");
            index = scanner.nextInt();
            if (index >= 0 && index <= 9) {
                System.out.printf("Prime at index %d is %d", index, primes[index]);
            } else System.err.println("Index was not an int between 0..9");
        }
    }
}
