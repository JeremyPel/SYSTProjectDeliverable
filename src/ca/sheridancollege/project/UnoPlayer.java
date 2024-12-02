package ca.sheridancollege.project;

public class UnoPlayer extends Player {   
    // Starting hand size for Uno is 7
    private Hand hand = new Hand(7);
    
    public UnoPlayer(String name) {
        super(name);
    }
    
    public void addCardToHand(UnoCard card) {
        hand.addCard(card);
    }
    
    public void showHand() {
        hand.displayHand();
    }
    
    @Override
    public void play() {
        
    }
}
