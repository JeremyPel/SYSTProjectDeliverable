package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

public class UnoGame {
    private ArrayList<UnoPlayer> players = new ArrayList<UnoPlayer>();
    private UnoDeck deck;
    private UnoCard topCard;
    private int currentPlayerIndex;
    Scanner scn = new Scanner(System.in);
    
    public UnoGame(ArrayList<UnoPlayer> players){
        this.players = players;
    }
    
    // Get player names
    public void startGame() {
        
    }
    
    // Loop the game until a player reaches 0 cards
    public void play() {
        int i = 0;
        do {
        players.get(i).showHand();
        
        // Upon reaching the last player go back to player index 0, otherwise go one player up
        i++;
        if(i == players.size()) {
            i = 0;
            }    
        }
        while (i < players.size() + 1);
    }
    
    public void declareWinner() {
        
    }
    

}
