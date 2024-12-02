package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

//SUPPOSED to extend Game but doesnt work for some reason
public class UnoGame {
    private ArrayList<UnoPlayer> players = new ArrayList<UnoPlayer>();
    private UnoDeck deck = new UnoDeck(1);
    private UnoCard topCard = deck.draw(); // temporary value 
    private int currentPlayerIndex;
    Scanner scn = new Scanner(System.in);
    
    public UnoGame(ArrayList<UnoPlayer> players){
        this.players = players;
    }
    
    // Get and set player names
    public void startGame() {
        int noMoreNames = 1;
        System.out.println("Would you like to add a player? 1 for yes, 2 for no: ");
    }
    
    // Loop the game until a player reaches 0 cards
    public void play() {
        int i = 0;
        do {
            // Display the top card that players must match with
            System.out.println(topCard.toString());
            
            // Show the player their hand, then ask them to select a card
            players.get(i).getName();
            players.get(i).showHand();      
            System.out.println("\nInput a number to select a card: ");
            int chosenCard = scn.nextInt() - 1;
        
            // Check if the chosen card is a wild card and thus doesn't need to match
        
            // Check if the chosen card matches or not
            System.out.print("YOU CHOSE CARD: ");
            players.get(i).showCard(chosenCard);
            if (players.get(i).getCardColor(chosenCard) == topCard.getColor() || players.get(i).getCardValue(chosenCard) == topCard.getValue()) {
                System.out.println("Card matches!\n");
            }
            else {
                System.out.println("Not a match...\n");
            }      
                    
            // Upon reaching the last player go back to player index 0, otherwise go one player up
            i++;
            if (i == players.size() || i > players.size()) {
                i = 0;
                }    
        }
        while (i < players.size() + 1);
    }
    
    public void declareWinner() {
        
    }
    
}
