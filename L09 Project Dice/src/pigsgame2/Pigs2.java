package pigsgame2;

import java.util.Scanner;

public class Pigs2 {
    public static int playerOneSum = 0;
    public static int playerTwoSum = 0;
    public static boolean hasWon = false;
    public static int winningSum = 100;
    public static int playerOneRolls = 0;
    public static int playerTwoRolls = 0;
    public static int rounds = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hvad ønskes der at spilles til?");
        winningSum = scanner.nextInt();
        playPig();
    }
    private static void playPig(){
        while(!hasWon){
            playRound();
            rounds++;
        }
        if (playerOneSum > playerTwoSum){
            System.out.println("Spiller 1 vinder med en sum på " + playerOneSum);
        } else System.out.println("Spiller 2 vinder med en sum på " + playerTwoSum);
        printStats();
    }
    private static void playRound() {
        int roll = 0;
        int[] diceArr = new int[2];
        int temp = 0;
        boolean playerOneCont = true;
        int playerOneTempSum = 0;
        boolean playerTwoCont = true;
        int playerTwoTempSum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Spiller 1 tur");
        System.out.println("Din totale sum er " + playerOneSum);
        System.out.println();
        while (playerOneCont && diceArr[0] != 1 && diceArr[1] != 1) {
            diceArr = rollDice();
            playerOneRolls++;
            roll = sumOfRoll(diceArr);
            if (diceArr[0] != 1 && diceArr[1] != 1) {
                playerOneTempSum += roll;
                System.out.println("Du rullede " + roll + " for en temp sum af " + playerOneTempSum);
                System.out.println("Rul igen tast 1, tast 2 for stop");
                if (scanner.nextInt() == 2) {
                    playerOneCont = false;
                    System.out.println();
                }

            }
            else if (diceArr[0] == 1 && diceArr[1] == 1){
                playerOneSum = 0;
                playerOneTempSum = 0;
                System.out.println("Du rullede dobbelt 1 og har mistet alle point");
                System.out.println();
            }
            else {
                System.out.println("Du rullede 1. Din tur er over og din temp sum er tabt");
                System.out.println();
                playerOneTempSum = 0;

            }
        }
        diceArr = new int[2];

        System.out.println("Spiller 2 tur");
        System.out.println("Din totale sum er " + playerTwoSum);
        System.out.println();
        while (playerTwoCont && diceArr[0] != 1 && diceArr[1] != 1) {
            diceArr = rollDice();
            playerTwoRolls++;
            roll = sumOfRoll(diceArr);
            if (diceArr[0] != 1 && diceArr[1] != 1) {
                playerTwoTempSum += roll;
                System.out.println("Du rullede " + roll + " for en temp sum af " + playerTwoTempSum);
                System.out.println("Rul igen tast 1, tast 2 for stop");
                if (scanner.nextInt() == 2) {
                    playerTwoCont = false;
                    System.out.println();
                }
            } else if (diceArr[0] == 1 && diceArr [1] == 1){
                playerTwoSum = 0;
                playerTwoTempSum = 0;
                System.out.println("Du rullede dobbelt 1 og mistet alle point");
                System.out.println();

            } else {
                System.out.println("Du rullede 1. Din tur er over og din temp sum er tabt");
                System.out.println();
                playerTwoTempSum = 0;
            }
        }
        playerOneSum += playerOneTempSum;
        playerTwoSum += playerTwoTempSum;
        if (playerOneSum >= winningSum || playerTwoSum >= winningSum){
            hasWon = true;
        }
    }
    private static int sumOfRoll(int[] rollsArr)
    {
        int sum = rollsArr[0] + rollsArr[1];
        return sum;
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
    private static void printStats(){
        System.out.println("Spiller 1 har i gennemsnittet rullet " + playerOneRolls/rounds + " per runde");
        System.out.println("Spiller 2 har i gennemsnittet rullet " + playerTwoRolls/rounds + " per runde");
    }
}
