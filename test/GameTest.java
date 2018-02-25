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

}
