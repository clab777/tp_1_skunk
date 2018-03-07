import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Round {

	// Create game objects (Die, Scanner, Player)
	private RolledDie die1;
	private RolledDie die2;
	private Scanner in;
	private Chips totalChipsforThisTurn;
	private Player winner;
	private int score;
		
     public Player getWinner() {
		return winner;
	}

	public void setWinner(Player winner) {
		this.winner = winner;
	}

	public Round()
	{
		score = 0;
	}
  
    /**
     * Play a round
     * @param players List of player
     * @return roundWinner, a Player.
     */
	public boolean playerTurn(Player player)
	{
		die1 = new RolledDie();
		die2 = new RolledDie();
		
		int rollDie1 = die1.roll();
		int rollDie2 = die2.roll();
		int rollTotal = rollDie1 + rollDie2 ;
		boolean nextTurn = false;
		
		if(hasRolledASkunk(rollDie1, rollDie2))
		{
			StdOut.println("You rolled a ***skunk***. You lose your points and 1 chip for this round! You will have to wait for next round.");
			rollTotal = 0;
			nextTurn = true;
			player.drawsChip(1);
			totalChipsforThisTurn.recievesSkunk();
		}
		else if(hasRolledDoubleSkunk(rollDie1, rollDie2))
		{
			StdOut.println("You rolled a ***double skunk***. You lose all your points and 4 chips for this round and your grand total points! You will have to wait for next round.");
			rollTotal = 0;
			player.setScore(0);
			nextTurn = true;
			player.drawsChip(4);
			totalChipsforThisTurn.recieves2Skunk();
		}
		else if(hasRolledASkunkandDeuce(rollDie1, rollDie2))
		{
			StdOut.println("You rolled a ***skunk and deuce***. You lose  your points and 2 chips for this round ! You will have to wait for next round.");
			rollTotal = 0;
			nextTurn = true;
			player.drawsChip(2);
			totalChipsforThisTurn.recieves1Skunkand1Deuce();
		}
		
		player.addScore(rollTotal);
		
		return nextTurn;
	}


   
    private boolean hasRolledDoubleSkunk(int roll1, int roll2) {
    	return (roll1 == 1 && roll2 == 1);
    }

	private boolean hasRolledASkunk(int roll1, int roll2) {
 	   return (roll1 == 1 || roll2 == 1);
	}
	
	private boolean hasRolledASkunkandDeuce(int roll1, int roll2){
		return ((roll1 == 1 && roll2 == 2) ||(roll1 == 2 && roll2 == 1)); 
	}

	public int roll(Die d) {
    	return d.roll();
    }


}
