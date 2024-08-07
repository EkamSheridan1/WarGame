import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public void drawCard(GroupOfCards deck) {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.add(drawnCard);
            System.out.println(name + " draws a card: " + drawnCard);
        }
    }

    public Card playCard() {
        if (!hand.isEmpty()) {
            return hand.remove(hand.size() - 1);
        }
        return null;
    }

    public Card playSpecificCard(String cardDescription) {
        for (Card card : hand) {
            if (card.toString().equalsIgnoreCase(cardDescription)) {
                hand.remove(card);
                return card;
            }
        }
        return null;
    }

    public String showHand() {
        return hand.toString();
    }

    public int getHandSize() {
        return hand.size();
    }

    public String getName() {
        return name;
    }
}

