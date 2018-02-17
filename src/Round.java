import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class Round {

	// Create game objects (Die, Scanner, Player)
	private RolledDie die1;
	private RolledDie die2;
//	private Scanner in;
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
//    	 in = new Scanner(System.in);

   
    	Player roundWinner = null;

		for(Player player : players){
			StdOut.println("-----------------------------------------------------------------------------------------");
			StdOut.println("Welcome to the game of Skunk, " +player.getName() +" Let's play some game!");
			StdOut.println("-----------------------------------------------------------------------------------------");
			
			boolean nextTurn = false;
			
			while (!nextTurn) {
				StdOut.println("Press [enter] to play a round....");
				
				// Roll the dice for the first time
//				in.nextLine();

				int roll1 = die1.roll();
				int roll2 = die2.roll();

				int rollTotal = roll1 + roll2;

				StdOut.println("You rolled a " + roll1 + " and a " + roll2);
				StdOut.println("For a total of " + rollTotal);
				StdOut.println("Your score for the round is " +rollTotal);
				StdOut.println();
				
				//-------------------------------------------------------
				//The game logic will be implemented here
				//-------------------------------------------------------

				//TODO #1
				//Find out if skunk "1" was rolled?
				//IF (SO) then take away score for the round
				//NextPlayer's turn to play
				
				
				//TODO #2
				// Find out if double skunk "1", "1" was rolled?
				// IF(SO) then the player lose points for the round and all of his points.
				//NextPlayer's turn to play

				
				//TODO #3
				// ELSE keep rolling and adding up points to match or beat the GOAL

				
				
				nextTurn = true;
				player.setScore(rollTotal);

			}
			
			roundWinner = players.stream().max(Comparator.comparing(Player::getScore)).orElseThrow(NoSuchElementException::new);
			
			setWinner(roundWinner);			
		}
		StdOut.println();
		StdOut.println("******************************************************************************************************");
		StdOut.println("The game winner is: ***" +roundWinner.getName() +"***" + " - TotalScore is: " +roundWinner.getScore());
		StdOut.println("******************************************************************************************************");
		StdOut.println();
		StdOut.println("Good game!");
		StdOut.println("Goodbye, thanks for playing!");		
		return roundWinner;
    }


   
    public int roll(Die d) {
    	return d.roll();
    }


}
