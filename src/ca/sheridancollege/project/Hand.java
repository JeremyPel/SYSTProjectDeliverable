package ca.sheridancollege.project;

import java.util.ArrayList;

public class Hand extends GroupOfCards {
    private ArrayList<UnoCard> unoHand = new ArrayList<UnoCard>();
    
    public Hand(int size) {
        super(size);
    }
    
    // Add to, remove from, or display player's hand of cards
    public void addCard(UnoCard card) {
        unoHand.add(card);
    }
    
    public void removeCard(UnoCard card) {
        unoHand.remove(card);
    }
    
    public void displayHand() {
        int i = 1;
        for (UnoCard card : unoHand) {
            System.out.println("Card " + i + ": " + card);
            i++;
        }
        
    }
    
    // For checking to see if player has reached 0 cards
    public int countHandSize() {
        return unoHand.size();
    }
}
