package ca.sheridancollege.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //THIS IS ALL A TEST
        //Set UnoPlayer names
        UnoPlayer guyOne = new UnoPlayer("Greg");
        UnoPlayer guyTwo = new UnoPlayer("Breb");
        UnoPlayer guyThree = new UnoPlayer("Mrem");
        
        //Give them cards
        guyOne.addCardToHand(new UnoCard(UnoCard.Color.BLUE, UnoCard.Value.ZERO));
        guyOne.addCardToHand(new UnoCard(UnoCard.Color.BLUE, UnoCard.Value.ONE));
        guyTwo.addCardToHand(new UnoCard(UnoCard.Color.RED, UnoCard.Value.EIGHT));
        guyTwo.addCardToHand(new UnoCard(UnoCard.Color.RED, UnoCard.Value.NINE));
        guyThree.addCardToHand(new UnoCard(UnoCard.Color.BLUE, UnoCard.Value.THREE));
        guyThree.addCardToHand(new UnoCard(UnoCard.Color.RED, UnoCard.Value.FOUR));
        
        //Make arraylist of UnoPlayers
        ArrayList<UnoPlayer> thePlayers = new ArrayList<UnoPlayer>();
        thePlayers.add(guyOne);
        thePlayers.add(guyTwo);
        thePlayers.add(guyThree);
    
        //Game
        UnoGame theGame = new UnoGame(thePlayers);
        theGame.play();

    }
}