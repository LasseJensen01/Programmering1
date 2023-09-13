package onedie;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Scanner;

public class RollOneDie {
    private static int rollCount = 0;
    private static int rollSum = 0;
    private static int sameRollOccurences = 0;
    private static int maxComRoll = 0;
    private static int[] arrRollOcc = new int[7];

    public static void main(String[] args) {
        System.out.println("Welcome to the game of RollOneDie");
        printRules();
        System.out.println();

        playOneDie();

        System.out.println();
        System.out.println("Thank you for playing RollOneDie");
    }

    private static void printRules() {
        System.out.println("=====================================================");
        System.out.println("Rules of RollOneDie:");
        System.out.println("The player throws one die as long as he/she wants.");
        System.out.println("=====================================================");
    }

    private static void playOneDie() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Roll? ('no' stops) ");
        String answer = scanner.nextLine();
        while (!answer.equals("no")) {
            int[] face = rollDice();
            System.out.println("Eyes: " + Arrays.toString(face));
            System.out.println();

            updateStatistics(face);

            System.out.print("Roll? ('no' stops) ");
            answer = scanner.nextLine();
        }

        printStatistics();
        scanner.close();
    }

    private static int[] rollDice() {
        int[] retArr = new int[2];
        for(int i = 0; i < retArr.length;i++){
            retArr[i] = generateRoll();
            arrRollOcc[retArr[i]]++;
        }
        if (retArr[0] == retArr[1]){
            sameRollOccurences++;
        }
        if (retArr[0] + retArr[1] > maxComRoll){
            maxComRoll = retArr[0] + retArr[1];
        }
        return retArr;
    }

    private static void updateStatistics(int[] face) {
        rollCount++;
        for(int i = 0; i < face.length;i++){
            rollSum += face[i];
        }
    }

    private static void printStatistics() {
        System.out.println("\nResults:");
        System.out.println("-------");
        System.out.printf("%17s %4d\n%17s %4d\n%17s %4d\n%17s %4d", "Roll count:", rollCount,"Total sum of the eyes:", rollSum, "Amount of times eyes were the same:", sameRollOccurences, "The higest roll was:", maxComRoll);
        System.out.println();
        for(int i = 1; i < arrRollOcc.length;i++){
            String time = " times";
            if(arrRollOcc[i] == 1){
                time = " time";
            }
            System.out.println("You rolled " + i + " " + arrRollOcc[i] + time);
        }
    }
    private static int generateRoll(){
        return (int) (Math.random() * 6 + 1);
    }
}
