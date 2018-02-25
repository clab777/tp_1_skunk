import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Round {

	// Create game objects (Die, Scanner, Player)
	private RolledDie die1;
	private RolledDie die2;
	private Scanner in;
	private Game game1;
	private Player winner;
		
     public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

  
    /**
     * Play a round
     * @param players List of player
     * @return roundWinner, a Player.
     */
    public Player playRound(int goal, List<Player> players){
     	 die1 = new RolledDie();
    	 die2 = new RolledDie();
    	 in = new Scanner(System.in);
    	 game1 = new Game();
   
    	Player roundWinner = null;

		for(Player player : players){
			StdOut.println("-----------------------------------------------------------------------------------------");
			StdOut.println("Welcome to the game of Skunk, " +player.getName() +" Let's play some game!");
			StdOut.println("-----------------------------------------------------------------------------------------");
			
			boolean nextTurn = false;
			int roundScore = 0;
			
			while (!nextTurn) {
				StdOut.println("Press [enter] to play a round....");
				
				// Roll the dice for the first time
//				in.nextLine();

				int roll1 = die1.roll();
				int roll2 = die2.roll();

				int rollTotal = roll1 + roll2;

				StdOut.println();
				StdOut.println("You rolled a " + roll1 + " and a " + roll2 +"\nA total of " + rollTotal + " for this round");
				StdOut.println();
				
				//-------------------------------------------------------
				//The game logic will be implemented here
				//-------------------------------------------------------

				if (hasRolledASkunk(roll1, roll2)) {
					StdOut.println("You rolled a ***skunk***. You lose your points for this round! You will have to wait for next round.");
					rollTotal = 0;

					StdOut.println("Your score for the round is " +roundScore);
					StdOut.println();

					//nextPlayer's turn
					nextTurn = true;
					break;
				} else if (hasRolledDoubleSkunk(roll1, roll2)) { 
					// Find out if double skunk "1", "1" was rolled?
					// IF(hasRolledDoubleSkunk) then the player lose points for the round and all of his points.
					StdOut.println("You rolled a ***double skunk***. You lose all your points for this round and your grand total points! You will have to wait for next round.");

					//take away points and score
					rollTotal = 0;
					player.setScore(0);
					
					StdOut.println("Your score for the round is " +roundScore);
					StdOut.println();
					
					//nextPlayer's turn
					nextTurn = true;
					break;					
				}else{

					roundScore = rollTotal;
					player.setScore(player.getScore() + roundScore); 
					
					nextTurn = true;
					
					//TODO #3
					// ELSE keep rolling and adding up points to match or beat the GOAL
				}
			}			
			StdOut.println("Your [GrandTotal] score is " +player.getScore());
			StdOut.println();

			player.setScore(player.getScore()); 

			
			roundWinner = players.stream().max(Comparator.comparing(Player::getScore)).orElseThrow(NoSuchElementException::new);
			
			setWinner(roundWinner);			
		}
		StdOut.println();
		StdOut.println("******************************************************************************************************");
		StdOut.println("The game winner is: ***" +roundWinner.getName() +"***" + " - TotalScore is: " +roundWinner.getScore() + " - Total chip in the Kitty is: " + game1.getTotalChips());
		StdOut.println("******************************************************************************************************");
		StdOut.println();
		StdOut.println("Good game!");
		StdOut.println("Goodbye, thanks for playing!");		
		return roundWinner;
    }


   
    private boolean hasRolledDoubleSkunk(int roll1, int roll2) {
    	return (roll1 == 1 && roll2 == 1);
    }

	private boolean hasRolledASkunk(int roll1, int roll2) {
 	   return (roll1 == 1 || roll2 == 1);
	}

	public int roll(Die d) {
    	return d.roll();
    }


}
