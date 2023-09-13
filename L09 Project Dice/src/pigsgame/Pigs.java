package pigsgame;

import java.security.KeyStore;
import java.util.Scanner;

public class Pigs {
    public static int playerOneSum = 0;
    public static int playerTwoSum = 0;
    public static boolean hasWon = false;
    public static void main(String[] args) {
        playPig();
    }
    private static void playPig(){
        while(!hasWon){
            playRound();
        }
        if (playerOneSum > playerTwoSum){
            System.out.println("Spiller 1 vinder med en sum på " + playerOneSum);
        } else System.out.println("Spiller 2 vinder med en sum på " + playerTwoSum);
    }
    private static void playRound() {
        int roll = 0;
        int temp = 0;
        boolean playerOneCont = true;
        int playerOneTempSum = 0;
        boolean playerTwoCont = true;
        int playerTwoTempSum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Spiller 1 tur");
        System.out.println("Din totale sum er " + playerOneSum);
        System.out.println();
        while (playerOneCont && roll != 1) {
            roll = rollDie();
            if (roll != 1) {
                playerOneTempSum += roll;
                System.out.println("Du rullede " + roll + " for en temp sum af " + playerOneTempSum);
                System.out.println("Rul igen tast 1, tast 2 for stop");
                if (scanner.nextInt() == 2) {
                    playerOneCont = false;
                    System.out.println();
                }
            } else {
                System.out.println("Du rullede 1. Din tur er over og din temp sum er tabt");
                System.out.println();
                playerOneTempSum = 0;

            }
        }
        roll = 0;
        System.out.println("------------------");
        System.out.println("Spiller 2 tur");
        System.out.println("Din totale sum er " + playerTwoSum);
        System.out.println();
        while (playerTwoCont && roll != 1) {
            roll = rollDie();
            if (roll != 1) {
                playerTwoTempSum += roll;
                System.out.println("Du rullede " + roll + " for en temp sum af " + playerTwoTempSum);
                System.out.println("Rul igen tast 1, tast 2 for stop");
                if (scanner.nextInt() == 2) {
                    playerTwoCont = false;
                    System.out.println();
                }
            } else {
                System.out.println("Du rullede 1. Din tur er over og din temp sum er tabt");
                System.out.println();
                playerTwoTempSum = 0;
            }
        }
        playerOneSum += playerOneTempSum;
        playerTwoSum += playerTwoTempSum;
        if (playerOneSum > 100 || playerTwoSum > 100){
            hasWon = true;
        }
    }


    private static int rollDie(){
        return (int) (Math.random() * 6 + 1);
    }
}
