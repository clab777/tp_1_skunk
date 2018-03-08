import java.util.Scanner;

public class SkunkApp {

	private static int POINTS_TO_WIN = 100;
    private static Round round;
    private static Scanner scanner;

    public static void main(String[] args) {
    	Player player1 = new Player(10, "Christophe");
    	Player player2 = new Player(20, "Sinith");
    	
    	playARound(player1, player2, POINTS_TO_WIN);
    }
    
    public static Player playARound(Player player1, Player player2, int goal){
    	round = new Round(player1,player2, POINTS_TO_WIN);
    	scanner = new Scanner(System.in);
    	StdOut.println("***************************************************************************"); 
        StdOut.println("Welcome to the Game of SKUNK! Let's play...");
    	StdOut.println("***************************************************************************"); 

    	while (!round.isOver() ) {
           playOneTurn();
        }
        
    	printScores(player1, player2);
        
    	StdOut.println("***************************************************************************"); 
        StdOut.println("           Game over! The winner is: " + round.getWinner().getName());
		StdOut.println("           GOODBYE... THANKS FOR PLAYING!!!                     "); 
		StdOut.println("***************************************************************************"); 
		
		return round.getWinner();
    }

    private static void playOneTurn() {
    	StdOut.println("-------------------------------");
        StdOut.println("Now playing: " + round.currentPlayer().getName() + "...");
    	StdOut.println("-------------------------------");
        while(!round.currentTurn().isOver()) {
            StdOut.println("This turn's score is " + round.currentTurn().getTurnScore());
            StdOut.println("Want to play again? 1-(Yes) or  2-(No)");
			int userChoice = scanner.nextInt();

            if (userChoice == 2) {
                round.caskOutPoints();
            } else {
            	ScoreInfo  scoreInfo = round.roll();  
            	printMessage(scoreInfo);
            }
        }
        if (!round.isOver()) {
            round.startNextTurn();
        }
    }

    private static void printMessage(ScoreInfo scoreInfo) {
    	if(scoreInfo != null && scoreInfo.getMessage() != null){
    		StdOut.println(scoreInfo.getMessage());
    	}
	}

	private static void printScores(Player player1, Player player2) {
    	StdOut.println("\n");
    	StdOut.println("+++++++++++++++++++++++++++++++++");
    	StdOut.println("+++        Scorecard          +++");
       	StdOut.println("+++++++++++++++++++++++++++++++++");
       	StdOut.println("");
        StdOut.println(player1.getName() + "'s score is " + player1.getScore());
        StdOut.println(player2.getName() + "'s score is " + player2.getScore());
    	StdOut.println("\n");
    }
}
