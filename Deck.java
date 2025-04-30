import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Deck {
    ArrayList<Card> cards;

    // Constructor initializes deck
    public Deck() {
        createDeck();
    }

    // Create the full deck of 52 cards
    public void createDeck() {
        cards = new ArrayList<>();
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    // Display full deck
    public void printDeck() {
        for (Card c : cards) {
            System.out.println(c);
        }
    }

    // Print specific card by index
    public void printCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter card index (0-51): ");
        int index = sc.nextInt();
        if (index >= 0 && index < cards.size()) {
            System.out.println("Card: " + cards.get(index));
        } else {
            System.out.println("Invalid index.");
        }
    }

    // Print all cards of same suit
    public void sameCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter suit (Hearts, Diamonds, Clubs, Spades): ");
        String suit = sc.nextLine();
        for (Card c : cards) {
            if (c.suit.equalsIgnoreCase(suit)) {
                System.out.println(c);
            }
        }
    }

    // Print all cards of same rank
    public void compareCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rank (2-10, Jack, Queen, King, Ace): ");
        String rank = sc.nextLine();
        for (Card c : cards) {
            if (c.rank.equalsIgnoreCase(rank)) {
                System.out.println(c);
            }
        }
    }

    // Search for a specific card
    public void findCard() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter rank: ");
        String rank = sc.nextLine();
        System.out.print("Enter suit: ");
        String suit = sc.nextLine();

        for (Card c : cards) {
            if (c.rank.equalsIgnoreCase(rank) && c.suit.equalsIgnoreCase(suit)) {
                System.out.println("Card found: " + c);
                return;
            }
        }
        System.out.println("Card not found.");
    }

    // Deal 5 random cards
    public void dealCard() {
        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            Card c = cards.get(rand.nextInt(cards.size()));
            System.out.println("Dealt: " + c);
        }
    }

    // Shuffle the deck randomly
    public void shuffleDeck() {
        Collections.shuffle(cards);
        System.out.println("Deck shuffled.");
    }

    // Display menu and call corresponding methods
    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("""
                MENU:
                1. Print Deck
                2. Print Specific Card
                3. Show All Cards of Same Suit
                4. Show All Cards of Same Rank
                5. Search for a Card
                6. Deal 5 Random Cards
                7. Shuffle Deck
                8. Exit
                Enter your choice: 
            """);
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> printDeck();
                case 2 -> printCard();
                case 3 -> sameCard();
                case 4 -> compareCard();
                case 5 -> findCard();
                case 6 -> dealCard();
                case 7 -> shuffleDeck();
                case 8 -> System.out.println("Exiting program.");
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 8);
    }
}
