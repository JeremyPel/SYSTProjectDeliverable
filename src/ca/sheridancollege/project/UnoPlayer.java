package ca.sheridancollege.project;


public class UnoPlayer extends Player {   
    // Starting hand size for Uno is 7
    private Hand hand = new Hand(7);
    
    public UnoPlayer(String name) {
        super(name);
    }
    
    public void addCard(UnoCard card) {
        hand.addCard(card);
    }
    
    public void showHand() {
        hand.displayHand();
    }
    
    public Hand getHand() {
    	return this.hand;
    }
    
    public UnoCard getCard(int index) {
        return hand.get(index);
    }
    
    @Override
    public void play() {
        
    } 
}
