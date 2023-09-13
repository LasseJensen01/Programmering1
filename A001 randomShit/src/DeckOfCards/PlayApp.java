package DeckOfCards;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayApp {
    private static card card;
    private static ArrayList<card> playerCards = new ArrayList<>();
    private static ArrayList<card> dealerCards = new ArrayList<>();
    private static int playerSum = 0;
    private static int dealerSum = 0;
    private static deckOfCards bjdeck = new deckOfCards();

    public static void main(String[] args) {
        playBlackJack();
    }

    public static void playBlackJack() {
        // Initializr deck
        bjdeck.initializeDeckOfCards();
        bjdeck.resetDeck();
        Scanner scanner1 = new Scanner(System.in);

        // Deal the Player two cards
        card = bjdeck.drawCard();
        playerCards.add(card);
        playerSum += checkValue();
        System.out.print("You drew the " + card.getRank() + " of " + card.getSuit());
        card = bjdeck.drawCard();
        playerCards.add(card);
        playerSum += checkValue();
        System.out.print(" and the " + card.getRank() + " of " + card.getSuit() + " for a sum of " + playerSum);
        System.out.println();

        // Deal the Dealer two cards, hide one
        card = bjdeck.drawCard();
        dealerCards.add(card);
        dealerSum += checkValue();
        System.out.println("Dealer drew the " + card.getRank() + " of " + card.getSuit() + " for a sum of " + dealerSum);
        card = bjdeck.drawCard();
        dealerCards.add(card);
        dealerSum += checkValue();
    }

    public static void playerTurn() {
        boolean playerContHit = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your sum is + " + playerSum + ". Do you wish to hit or stand?");
        System.out.println("Type Hit to draw another card and Stand to draw no more");
        String d = scanner.nextLine();
        while (playerContHit) {
            if (d.equals("Hit") || d.equals("hit")) {
                // Draw another card
                card = bjdeck.drawCard();
                playerCards.add(card);
                playerSum += checkValue();
                System.out.println("You drew the " + card.getRank() + " of " + card.getSuit());
            } else if (d.equals("Stand") || d.equals("stand")){
                // Stop drawing
                playerContHit = false;
            } else{
                System.out.println("Invalid input. Please only enter valid inputs");
            }
        }
    }
    public static void playerValCheck(){
        if (playerSum > 21){
            // Player loses
            // TODO
        } else if (playerSum == 21){
            // Player has 21 and stops
            // TODO
        }
    }

    public static int checkValue() {
        int returnVal = 0;
        switch (card.getRank()) {
            case "2" -> returnVal = 2;
            case "3" -> returnVal = 3;
            case "4" -> returnVal = 4;
            case "5" -> returnVal = 5;
            case "6" -> returnVal = 6;
            case "7" -> returnVal = 7;
            case "8" -> returnVal = 8;
            case "9" -> returnVal = 9;
            case "10" -> returnVal = 10;
            case "Jack" -> returnVal = 10;
            case "Queen" -> returnVal = 10;
            case "King" -> returnVal = 10;
            case "Ace" -> returnVal = 11;
            default -> returnVal = 0;
            // Just return val instead of giving new val every case
            // TODO
        }
        return returnVal;
    }

    //public static void drawcards(){
       /* deckOfCards newdeck = new deckOfCards();
        newdeck.initializeDeckOfCards();
        newdeck.resetDeck();
        Scanner scanner1 = new Scanner(System.in);
        while (keepDrawing) {
            card.add(newdeck.drawCard());
            System.out.println(card.get(0).getRank() + " of " + card.get(0).getSuit());
            cardCount++;
            if (cardCount >= 52) {
                newdeck.resetDeck();
                System.out.println("Resetting deck");
                cardCount = 0;
            }
            if (scanner1.nextLine().equals("no")) {
                keepDrawing = false;
            }
        }
    }*/
}
