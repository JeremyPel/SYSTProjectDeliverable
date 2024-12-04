package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

public class UnoDeck {
    private final ArrayList<UnoCard> unoCards = new ArrayList<UnoCard>();

    // Add number cards (0-9) for each color
    private void addNumberCards() {
        for (UnoCard.Color color : UnoCard.Color.values()) {
            if (color == UnoCard.Color.NONE)
                continue; // Skip NONE color as it is only for Wild cards

            // Add one "0" card
            unoCards.add(new UnoCard(color, UnoCard.Value.ZERO));

            // Add two of each card 1-9
            for (int i = UnoCard.Value.ONE.ordinal(); i <= UnoCard.Value.NINE.ordinal(); i++) {
                unoCards.add(new UnoCard(color, UnoCard.Value.values()[i]));
                unoCards.add(new UnoCard(color, UnoCard.Value.values()[i]));
            }
        }
    }

    // Add Skip, Reverse, and Draw Two cards: 8 of each (2 per color)
    private void addSpecialCards() {
        for (UnoCard.Color color : UnoCard.Color.values()) {
            if (color == UnoCard.Color.NONE)
                continue; // Skip NONE color

            for (int i = 0; i < 2; i++) {
                unoCards.add(new UnoCard(color, UnoCard.Value.SKIP));
                unoCards.add(new UnoCard(color, UnoCard.Value.DRAW_TWO));
            }
        }
    }

    // Add Wild and Wild Draw Four cards (4 each)
    private void addWildCards() {
        for (int i = 0; i < 4; i++) {
            unoCards.add(new UnoCard(UnoCard.Color.NONE, UnoCard.Value.WILD));
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(unoCards);
    }

    // Draw a card from the deck
    public UnoCard draw() {
        if (unoCards.isEmpty()) {
            System.out.println("Deck is empty!");
            return null;
        }
        return unoCards.remove(0);
    }

    // Constructor to create and shuffle the deck
    public UnoDeck(int size) {
        addNumberCards();
        addSpecialCards();
        addWildCards();
        shuffle();       
    }
}