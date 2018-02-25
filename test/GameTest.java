import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGetTotalChips() {
		Game game1 = new Game();
		assertEquals(0, game1.getTotalChips());
	}
	
	@Test
	public void testAddChiptothePot() {
		Game game1 = new Game();
		game1.addChip(1);
		assertEquals(1, game1.getTotalChips());
	}
	
	@Test
	public void testPlayerGet1Skunk()
	{
		Game game1 = new Game();
		Player p1 = new Player(1, "Sinith");
		game1.recievesSkunk();
		p1.drawsChip(1);
		assertEquals(49, p1.getTotalChipLeft());
		assertEquals(1, game1.getTotalChips());
	}
	
	@Test
	public void testPlayerGet2Skunk()
	{
		Game game1 = new Game();
		Player p1 = new Player(1, "Sinith");
		game1.recieves2Skunk();
		p1.drawsChip(4);
		assertEquals(46, p1.getTotalChipLeft());
		assertEquals(4, game1.getTotalChips());
	}
	
	@Test
	public void testPlayerGet1Skunkand1Deuce()
	{
		Game game1 = new Game();
		Player p1 = new Player(1, "Sinith");
		game1.recieves1Skunkand1Deuce();
		p1.drawsChip(2);
		assertEquals(48, p1.getTotalChipLeft());
		assertEquals(2, game1.getTotalChips());
	}

}
