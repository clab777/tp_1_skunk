

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SkunkAppTest {
	private static final int GOAL = 10;
	private List<Player> players = null;
	
	private SkunkApp app;
	

	@Before
	public void setUp() {
		app = new SkunkApp();
		players = new ArrayList<Player>();
	}

	@Test
	public void failTest() {
		if (app == null) {
			fail("SkunkApp is null, not instanciated!");
		}
	}	
	
	@Test
	public void testPlayGame(){
	
		Player player = new Player(1, "Christophe");
		players.add(player);
		
		player = new Player(4, "Sinith");
		players.add(player);
			
		
		Player winner = SkunkApp.playARound(players.get(0), players.get(1), GOAL);
		Assert.assertTrue(winner != null);
	}
}
