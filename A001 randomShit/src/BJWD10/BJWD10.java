package BJWD10;

import java.util.Scanner;

public class BJWD10 {
    public static void main(String[] args){
        int dealerStopVal = 0;
        int simRunVal = 100;
        System.out.println("Enter dealer stop value");
        Scanner scan1 = new Scanner(System.in);
        dealerStopVal = scan1.nextInt();
        runD10Sim(dealerStopVal, simRunVal);
    }
    public static Object runD10Sim(int dealerStopVal, int simRunVal){
        int dealerSum = 0;
        int playerSum = 0;
        int max = 10;
        int min = 1;
        int d1 = 0;
        int d2= 0;
        int dealerWins = 0;
        int playerWins = 0;
        int draws = 0;
        int range = max - min + 1;
        for(int i = 0; i < simRunVal; i++){
            d1 = (int) (Math.random() * range) + min;
            d2 = (int) (Math.random() * range) + min;
            if (d1 == d2){
                dealerSum += 1;
            }
            dealerSum += d1+d2;
            while (dealerSum <= dealerStopVal){
                dealerSum += (int) (Math.random() * range) + min;
            }
            d1 = (int) (Math.random() * range) + min;
            d2 = (int) (Math.random() * range) + min;
            if (d1 == d2){
                playerSum += 1;
            }
            playerSum += d1+d2;
            while (playerSum <= 17){
                playerSum += (int) (Math.random() * range) + min;
            }
            if (playerSum > 21){
                dealerWins++;
            } else if (dealerSum > 21){
                playerWins++;
            } else if (playerSum > dealerSum){
                playerWins++;
            } else if (playerSum == dealerSum){
                draws++;
            } else {
                dealerWins++;
            }
            //System.out.println("Dealer sum " + dealerSum + " Player sum " + playerSum);
            dealerSum = 0;
            playerSum = 0;
        }
        System.out.println("Dealer wins = " + dealerWins);
        System.out.println("Player wins = " + playerWins);
        System.out.println("Pushes = " + draws);
        return null;
    }
}
