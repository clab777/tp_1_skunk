import java.util.ArrayList;
import java.util.List;

public class SkunkApp {

    private static final int GOAL = 100; //THE GOAL TO REACH OR BEAT TO WIN THE GAME


	public static void main(String[] args){
		SkunkApp app = new SkunkApp();
		app.play(GOAL, getParticipants());
	}

	public Player play(int goal, List<Player> players) {
		Round round = new Round();

		//Round winner
		Player roundWinner = round.playRound(GOAL, players);
		
		return roundWinner;
	}

	private static List<Player> getParticipants(){
		List<Player> players = new ArrayList<Player>();
		
		Player player = new Player(1, "Christophe");
		players.add(player);
		
		player = new Player(2, "Elvis");
		players.add(player);
		
		player = new Player(3, "Eric");
		players.add(player);
	
		return players;
	}

}
