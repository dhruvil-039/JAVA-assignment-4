public class Card {
    String suit;
    String rank;

    // Constructor to initialize card
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    // String representation of card
    public String toString() {
        return rank + " of " + suit;
    }
}
