package DeckOfCards;

public class card {
    private String rank;
    private String suit;
    public card(String rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }
}
