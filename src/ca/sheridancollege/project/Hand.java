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
            System.out.println(i + ": " + card);
            i++;
        }
    }
    
    // For checking to see if player has reached 0 cards
    public int countHandSize() {
        return unoHand.size();
    }
    
    @Override
    public ArrayList<Card> getCards() {
    	return new ArrayList<>(unoHand);
    }
    
    public UnoCard getOneCard(int card) {
        return this.unoHand.get(card);
    }

	public UnoCard get(int index) {
		 if (index >= 0 && index < unoHand.size()) {
	            return unoHand.get(index);
	        } else {
	            // Return null or handle out-of-bounds index
	            System.out.println("Invalid index!");
	            return null;
	        }
	}
}
