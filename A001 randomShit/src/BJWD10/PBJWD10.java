package BJWD10;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class PBJWD10 {
    public static void main(String[] args) throws InterruptedException {
        int keepPlaying = 1;
        Scanner scan2 = new Scanner(System.in);
        //While loop to keep playing
        while (keepPlaying == 1) {
            play();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("Keep playing type 1. To quit type 2");
            keepPlaying = scan2.nextInt();
        }
    }

    public static void play() throws InterruptedException{
        int pD1 = 0;
        int pD2 = 0;
        int dD1 = 0;
        int dD2 = 0;
        int dealerStopVal = 17;
        int temp = 0;
        int temp2 = 0;
        int temp3 = 0;
        int playerSum = 0;
        int dealerSum = 0;
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        //Initialise scanner for hitting and standing
        Scanner scan1 = new Scanner(System.in);
        // Roll the dies for the dealer
        dD1 = (int) (Math.random() * range) + min;
        dD2 = (int) (Math.random() * range) + min;
        //Check to see if the dealer has a pair, if so add +1 to sum
        if (dD1 == dD2){
            dealerSum += 1;
        }
        dealerSum += dD1 + dD2;
        //Roll the players dice
        pD1 = (int) (Math.random() * range) + min;
        pD2 = (int) (Math.random() * range) + min;
        //Check to see if the player has a pair, if so add +1 to sum
        if (pD1 == pD2) {
            playerSum =+ 1;
        }
        playerSum += pD1+pD2;
        //Print to dealers hand and players hand
        System.out.println("Dealer has " + dD1);
        System.out.println("You have a " + pD1 + " and " + pD2 + " for a sum of " + playerSum);
        //Check possible ending results like 21
        if (playerSum == 21 && dealerSum == 21) {
            System.out.println("Both dealer and player has 21, push");
            return;
        } else if (playerSum == 21 && dealerSum != 21) {
            System.out.println("Player has 21 and wins!");
            System.out.println(dealerSum);
            return;
        } else if (dealerSum == 21 && playerSum != 21) {
            System.out.println("Dealer has 21 and wins");
            return;
        }

        //Play until player stops, gets 21 or busts
        while (playerSum < 21) {
            System.out.println("Type 1 for hit or 2 for stand");
            temp = scan1.nextInt();
            if (temp != 1 && temp != 2) {
                System.out.println("Invalid input terminating game");
                return;
            } else if (temp == 1) {
                temp2 = (int) (Math.random() * range) + min;
                playerSum += temp2;
                System.out.println("You rolled " + temp2 + " for a total of " + playerSum);
            } else if (temp == 2) {
                break;
            }
        }
        //Check to see if player busted
        if (playerSum > 21){
            System.out.println("Player busted. Dealer wins");
            return;
        }
        //Print dealer total and roll until reaching dealerStopVal(17)
        System.out.println("Dealer rolled a " + dD1 + " and a " + dD2 + " for a total of " + dealerSum);
        //Delay between lines for dRaMAtiC eFfeCt
        TimeUnit.SECONDS.sleep(1);
        while(dealerSum < dealerStopVal){
            if (dealerSum < dealerStopVal){
                temp3 = (int) (Math.random() * range) + min;
                dealerSum += temp3;
                System.out.println("Dealer rolled a " + temp3 + " for a total of " + dealerSum);
                TimeUnit.SECONDS.sleep(1);
            }
        }
        //Check results and print
        if (dealerSum > 21){
            System.out.println("Dealer busted. Player wins!");
        } else if (dealerSum > playerSum){
            System.out.println("Dealer has " + dealerSum + ". Player has " + playerSum + ". Dealer wins");
        } else if (dealerSum < playerSum){
            System.out.println("Dealer has " + dealerSum + ". Player has " + playerSum + ". Player wins!");
        } else if (dealerSum == playerSum) {
            System.out.println("Dealer has " + dealerSum + ". Player has " + playerSum + ". Push");
        } else {
            System.out.println("Error. Terminating game");
            return;
        }
        return;
    }
}
