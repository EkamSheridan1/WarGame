import java.util.ArrayList;
import java.util.Collections;

public class GroupOfCards {
    private ArrayList<Card> cards;

    public GroupOfCards() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int getRemainingCards() {
        return cards.size();
    }

    public void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        for (String suit : suits) {
            for (String value : values) {
                addCard(new Card(suit, value));
            }
        }
    }
}
