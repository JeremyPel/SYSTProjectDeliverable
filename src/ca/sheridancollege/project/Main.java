package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Game
        UnoGame game = new UnoGame("New Game");
        game.startGame();
        game.play();
    }
}

