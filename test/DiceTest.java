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
	public void testRoll(){
		int result = dice.roll();
		Assert.assertTrue(result > 1);
	}
	
	@Test
	public void testHasRolledASkunk() throws Exception{
		LoadedDie die1 = new LoadedDie(1);
		RolledDie die2 = new RolledDie();
		
		int roll1 = die1.roll();	
		int roll2 = die2.roll();	

		Assert.assertTrue(roll1 == 1 || roll2 == 1);
	}
	
	@Test
	public void testHasRolledDoubleSkunk(){
		LoadedDie die1 = new LoadedDie(1);
		LoadedDie die2 = new LoadedDie(1);
		
		int roll1 = die1.roll();	
		int roll2 = die2.roll();	
		
		Assert.assertTrue(roll1 == 1 && roll2 == 1);	
	}

}
