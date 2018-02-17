import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {

	Dice dice;
	@Before
    public void setUp() {
		dice = new Dice();
    }
	
	@Test
	public void testHasRolledASkunk() throws Exception{
		Die die1 = new Die(1);
		Die die2 = new Die();
		
		int roll1 = dice.roll(die1);	
		int roll2 = dice.roll(die2);	

		Assert.assertTrue(roll1 == 1 || roll2 == 1);
	}
	
	@Test
	public void testHasRolledDoubleSkunk(){
		Die die1 = new Die(1);
		Die die2 = new Die(1);
		
		int roll1 = dice.roll(die1);	
		int roll2 = dice.roll(die2);	
		
		Assert.assertTrue(roll1 == 1 && roll2 == 1);	
	}
	
	@Test
	public void testPlayRound(){
		List<Player> players = new ArrayList<Player>();
		
		Player player = new Player(1, "Christophe");
		players.add(player);

		player = new Player(2, "Elvis");
		players.add(player);

		//List of players
		dice.playRound(10, players);
		Player theWinner = dice.getWinner();
		
		Assert.assertTrue(theWinner.getScore() > 0);
	}
}
