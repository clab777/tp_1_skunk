import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoundTest {

	Round round;
	
	@Before
    public void setUp() {
		round = new Round();
    }

	
	@Test
	public void testPlayRound(){
		List<Player> players = new ArrayList<Player>();
		
		Player player = new Player(1, "Christophe");
		players.add(player);

		player = new Player(2, "Elvis");
		players.add(player);

		player = new Player(3, "Eric");
		players.add(player);

		//List of players
		//round.playRound(10, players);
		Player theWinner = round.getWinner();
		
		Assert.assertTrue(theWinner.getScore() > 0);
	}
}
