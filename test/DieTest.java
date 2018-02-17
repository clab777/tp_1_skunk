import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DieTest {
	Die die;
    @Before
    public void setUp() {
    	die = new Die();
    }

	@Test
	public void testLoadedDie(){
		die = new Die(1);
		int loadedValue = die.roll(1);
		Assert.assertTrue(loadedValue == 1);
	}

	@Test
	public void testRollDie(){
		int value = die.roll();
		Assert.assertTrue(value > 0);
	}
	
	
	
}
