import java.util.Scanner;

public class Game {
    private GroupOfCards deck;
    private Player player;
    private Player ai;
    private Scanner scanner;

    public Game() {
        scanner = new Scanner(System.in);

        // Ask for the player's name
        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        deck = new GroupOfCards();
        player = new Player(playerName);
        ai = new Player("AI");

        deck.initializeDeck();
        deck.shuffle();
    }

    public void playTurn() {
        // Player's turn
        System.out.println(player.getName() + ", it's your turn.");
        System.out.println("Your hand: " + player.showHand());
        System.out.println("Enter the rank of the card you want to play (2-10, Jack, Queen, King, Ace): ");
        String rank = scanner.nextLine();
        System.out.println("Enter the suit of the card you want to play (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();
        
        String cardDescription = rank + " of " + suit;
        Card playedCard = player.playSpecificCard(cardDescription);
        
        if (playedCard != null) {
            System.out.println(player.getName() + " plays: " + playedCard);
        } else {
            System.out.println("Invalid card. Please try again.");
        }

        // AI's turn
        ai.drawCard(deck);
        Card aiPlayedCard = ai.playCard();
        if (aiPlayedCard != null) {
            System.out.println(ai.getName() + " plays: " + aiPlayedCard);
        }

        // Display remaining cards in the deck
        System.out.println("Remaining cards in deck: " + deck.getRemainingCards());
    }

    public void startGame() {
        while (!isGameOver()) {
            playTurn();
        }
        System.out.println("Game Over!");
    }

    private boolean isGameOver() {
        return deck.getRemainingCards() == 0;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.startGame();
    }
}
