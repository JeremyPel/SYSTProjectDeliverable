package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

public class UnoGame extends Game{
  private ArrayList<UnoPlayer> players = new ArrayList<>();
  private UnoDeck deck = new UnoDeck(1);
  private UnoCard topCard = deck.draw(); 
  private int currentPlayerIndex;

  
  public UnoGame(String name){
  	super(name);
      players = new ArrayList();
      startGame();
      play();
  }
  
  
  // Get and set player names
  public void startGame() {
  	//ArrayList of Player Objects
//      ArrayList<UnoPlayer> players = new ArrayList<UnoPlayer>();
      
   // Create a Scanner for user input
      Scanner scanner = new Scanner(System.in);
      String input;
      
      System.out.println("Enter player names (type 'done' to stop):");


      // Loop to collect players
      while (true) {
          System.out.print("Enter player name: ");
          input = scanner.nextLine();

          // Check for exit condition
          if (input.equalsIgnoreCase("done")) {
              break;
          }

          // Create a new Player object and add it to the ArrayList
          UnoPlayer player = new UnoPlayer(input);
          players.add(player);
          System.out.println("Player added!");
      }
      deck.shuffle();
      dealCards();

      
  }
  //Check if move is valid
  public boolean isValidMove(UnoCard unoCard) {
 	 return unoCard.getColor().equals(topCard.getColor()) || 
              unoCard.getValue().equals(topCard.getValue());
 }
  
  //Check for special cards
  public boolean isWild(UnoCard unoCard) {
        return unoCard.getColor().equals(UnoCard.Color.NONE);
  }
  
  public boolean isDraw(UnoCard unoCard) {
      return unoCard.getValue().equals(UnoCard.Value.DRAW_TWO);
  }
  
  public boolean isSkip(UnoCard unoCard) {
      return unoCard.getValue().equals(UnoCard.Value.SKIP);
  }
  
  public void dealCards() {
      // Deal 7 cards to each player
      for (UnoPlayer player : players) {
          for (int i = 0; i < 7; i++) {
              player.getHand().addCard(deck.draw());  // Draw a card and add to player's hand
          }
      }
  }
  
  // Loop the game until a player reaches 0 cards
  @Override
  public void play() {
  	    Scanner scanner = new Scanner(System.in);
  	    currentPlayerIndex = 0; // Track whose turn it is
            boolean drawTwo = false;

  	    while (true) {                             
  	        // Get the current player
  	        UnoPlayer currentPlayer = players.get(currentPlayerIndex);
                
                // Check if player must draw 2
                if (drawTwo) {
                    UnoCard drawnCard = deck.draw();
                    currentPlayer.getHand().addCard(drawnCard);
                    currentPlayer.getHand().addCard(drawnCard);
                    System.out.println("The next player has two cards added to their deck");
                    drawTwo = false;
                }
                
                // Show player their deck
  	        System.out.println("\n" + currentPlayer.getName() + "'s Turn");
  	        System.out.println("Top Card: " + topCard);
  	        System.out.println("Your Hand: ");
  	        currentPlayer.getHand().displayHand();
                System.out.println("Hand size: " + currentPlayer.getHand().countHandSize());

  	        // Prompt the player for input
  	        System.out.println("Enter the card number to play or 0 to draw: ");
  	        int choice = scanner.nextInt();
  	        //Need to add check to see if drawn card matches the topCard before skipping turn.
  	        if (choice == 0) {
  	            // Player chooses to draw a card
  	            UnoCard drawnCard = deck.draw();
  	            currentPlayer.getHand().addCard(drawnCard);
  	            System.out.println("You drew: " + drawnCard);
  	        } else {
  	            // Player chooses a card from their hand
  	            try {
  	                Card selectedCard = currentPlayer.getHand().getCards().get(choice - 1);
                        // Wild; doesn't need to match
                        if (isWild((UnoCard)selectedCard)) {
                            topCard = (UnoCard)selectedCard;
                            System.out.println("1. Blue \n2. Red \n3. Green \n4. Yellow \nSelect a color:");
                            // Ask player to choose the color of the wild card
                            int colorChoice = scanner.nextInt();    
                              switch (colorChoice) {
                                  case 1:
                                      topCard.setColor(UnoCard.Color.BLUE);
                                      break;
                                  case 2:
                                      topCard.setColor(UnoCard.Color.RED);
                                      break;
                                  case 3:
                                      topCard.setColor(UnoCard.Color.GREEN);
                                      break;
                                  case 4:
                                      topCard.setColor(UnoCard.Color.YELLOW);
                                      break;
                                  default:
                                      break;
                              }
  	                    currentPlayer.getHand().removeCard((UnoCard)selectedCard);
  	                    System.out.println("You played: " + selectedCard);
                            if (currentPlayer.getHand().countHandSize() == 0) {
  	                        declareWinner();
  	                        break;
  	                    }
                        }
                        // Make next player draw 2
                        else if (isDraw((UnoCard)selectedCard)) {
                            topCard = (UnoCard)selectedCard;
                            currentPlayer.getHand().removeCard((UnoCard)selectedCard);
                            drawTwo = true;      
                            if (currentPlayer.getHand().countHandSize() == 0) {
  	                        declareWinner();
  	                        break;
  	                    }
                        }
                        // Skip next players turn by adding extra to currentPlayerIndex
                        else if (isSkip((UnoCard)selectedCard)) {
                            topCard = (UnoCard)selectedCard;
                            currentPlayer.getHand().removeCard((UnoCard)selectedCard);
                            System.out.println("The next player's turn is skipped!");
                            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
                            if (currentPlayer.getHand().countHandSize() == 0) {
  	                        declareWinner();
  	                        break;
  	                    }
                        }
                        // Regular card
                        else if (isValidMove((UnoCard)selectedCard)) {
  	                    // Valid move: Update the top card and remove it from the player's hand
  	                    topCard = (UnoCard)selectedCard;
  	                    currentPlayer.getHand().removeCard((UnoCard)selectedCard);
  	                    System.out.println("You played: " + selectedCard);

  	                    // Check if the player has won
  	                    if (currentPlayer.getHand().countHandSize() == 0) {
  	                        declareWinner();
  	                        break;
  	                    }
  	                } else {
  	                    // Invalid move: Notify the player
  	                    System.out.println("Invalid move! The card must match the top card in color or value, or be a wild card.");
                            UnoCard drawnCard = deck.draw();
                            currentPlayer.getHand().addCard(drawnCard);
                            System.out.println("You were forced to draw: " + drawnCard);
  	                }
  	            } catch (IndexOutOfBoundsException e) {
  	                // Handle invalid card choice
  	                System.out.println("Invalid choice! Please select a valid card number.");
                        UnoCard drawnCard = deck.draw();
                        currentPlayer.getHand().addCard(drawnCard);
                        System.out.println("You were forced to draw: " + drawnCard);
  	            }
  	        }

  	        // Move to the next player
  	        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
  	    }

  	    scanner.close();
  	}
  
  @Override
  public void declareWinner() {
  	System.out.println("\nCongratulations! You win the game!");
  }
  
}