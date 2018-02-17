import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DieTest {
	RolledDie die;
	LoadedDie loadeDie;

	@Before
    public void setUp() {
    	die = new RolledDie();
    }

	@Test
	public void testLoadedDie(){
		loadeDie = new LoadedDie(1);
		int loadedValue = loadeDie.roll();
		Assert.assertTrue(loadedValue == 1);
	}

	@Test
	public void testRollDie(){
		int value = die.roll();
		Assert.assertTrue(value > 0);
	}
	
	
	
}
