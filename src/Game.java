import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game 
{
	private int num_players ;
	private int GOAL = 100; //THE GOAL TO REACH OR BEAT TO WIN THE GAME
	List<Player> players = new ArrayList<Player>();
	
	public Game()
	{
		num_players = 0;
	}
	
	public void play()
	{
		Scanner reader = new Scanner(System.in);
		System.out.print("Enter number of players:");		
		num_players = reader.nextInt();
		if(num_players == 0)
		{
			System.out.println("No one Wins !!");
			reader.close();
		}
		this.collectUserID();
		this.startTheGame();
	}
	
	private void  collectUserID()
	{
		String playerID;
		Scanner reader = new Scanner(System.in);
		for(int i=0; i<num_players; i++)
		{
			System.out.print("Enter Player" + (i+1)+ " ID:");
			playerID = reader.nextLine();
			Player player = new Player(i, playerID);
			players.add(player);
		}
		reader.close();
	}
	
	public void startTheGame()
	{
		
	}
    
	public int getNumberofPlayers()
	{
		return num_players;
	}
}
