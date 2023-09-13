package DeckOfCards;


public class deckOfCards {
    private int count = 0;
    private String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    private int[] deck = new int[52];
    public deckOfCards(){
        this.suits = suits;
        this.ranks = ranks;
        this.deck = deck;
        this.count = count;
    }

    public void initializeDeckOfCards() {
        // Initialize cards
        for (int i = 0; i < deck.length; i++) {
            deck[i] = i;
        }
    }
    public void resetDeck(){
        // Shuffle the cards
        for (int i = 0; i < deck.length; i++) {
            int index = (int) (Math.random() * deck.length);
            int temp = deck[i];
            deck[i] = deck[index];
            deck[index] = temp;
        }
        count = 0;
    }
    public card drawCard(){
        // Call this to draw one card
        String suit = suits[deck[count] / 13];
        String rank = ranks[deck[count] % 13];
        count++;
        // Card will be returned as a Card Object
        card card = new card(rank, suit);
        return card;
    }
}
