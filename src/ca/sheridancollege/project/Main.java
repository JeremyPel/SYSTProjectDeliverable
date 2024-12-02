package ca.sheridancollege.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Set player name
        UnoPlayer guyOne = new UnoPlayer("Greg");
        UnoPlayer guyTwo = new UnoPlayer("Breb");
        ArrayList<UnoPlayer> thePlayers = new ArrayList<UnoPlayer>();
        thePlayers.add(guyOne);
        thePlayers.add(guyTwo);
    
        //Game
        UnoGame theGame = new UnoGame(thePlayers);
        theGame.play();
    }
}