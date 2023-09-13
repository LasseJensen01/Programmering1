package crapsgame;

import java.awt.*;
import java.util.Scanner;

public class Craps {
    public static int winCount = 0;
    public static int lossCount= 0;
    public static void main(String[] args) {
        Scanner scanner2 = new Scanner(System.in);
        boolean playAgain = true;
        while (playAgain) {
            playCraps();
            System.out.println("Spil igen tast 1. Stop spil tast 2.");
            if (scanner2.nextInt() != 1 )playAgain = false;
        }
        System.out.println("Du vandt " + winCount + " gange og tabte " + lossCount + " gange");
    }
    private static void printRules(){
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("Regler");
        System.out.println("------");
        System.out.println("Spillet består af en række kast med to terninger. Udfaldet af et kast er summen af de to terningers \n" +
                "øjne.  \n" +
                "Det første kast kaldes ‘come out roll’. Spilleren vinder med det samme, hvis det første kast er 7 \n" +
                "eller 11, og taber med det samme, hvis det første kast er 2, 3 eller 12. Hvis spillerens første kast er \n" +
                "4, 5, 6, 8, 9 eller 10, etableres dette tal som spillerens ‘point’. Spilleren bliver derefter ved med at \n" +
                "kaste, indtil han enten kaster sit ‘point’ igen eller kaster 7. Kaster han 7, har han tabt. Kaster han \n" +
                "sit ’point’, har han vundet. ");
        System.out.println("\nTryk enter for at starte" );
        scanner.nextLine();
    }
    private static void playCraps(){
        printRules();
        int point = startRoll();
        printResult(rollForPoint(point));
    }
    private static int startRoll(){
       int sum = sumOfRoll();
        System.out.println("Dit 'come out roll' er " + sum);
        System.out.println();
       if (sum == 2 || sum == 3 || sum == 12){
           return 0;
       } else if (sum == 7 || sum == 11){
           return 1;
       } else return sum;
    }

    private static int sumOfRoll()
    {
        int[] rollsArr = rollDice();
        int sum = rollsArr[0] + rollsArr[1];
        return sum;
    }
    private static boolean rollForPoint(int point){
        int newPoint = point;
        boolean continueRolling = true;
        boolean winningState = false;

        if(point == 0){
            winningState = false;
            continueRolling = false;
        }
        if (point == 1){
            winningState = true;
            continueRolling = false;
        }

        while(continueRolling){
             newPoint = sumOfRoll();
            System.out.println("Du har kastet " + newPoint);
            System.out.println();
             if (point == newPoint) {
                 winningState = true;
                 continueRolling = false;
             }else if (newPoint == 7){
                 winningState = false;
                 continueRolling = false;
             }
        }
        return winningState;
    }
    private static void printResult(boolean winningstate){
        if (winningstate) {
            System.out.println("Du vinder!");
            winCount++;
        }
        else {
            System.out.println("Du taber");
            lossCount++;
        }
    }

    private static int[] rollDice() {
        int[] retArr = new int[2];
        for(int i = 0; i < retArr.length;i++) {
            retArr[i] = generateRoll();
        }
        return retArr;
    }
    private static int generateRoll(){
        return (int) (Math.random() * 6 + 1);
    }
}
