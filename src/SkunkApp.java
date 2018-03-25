import java.util.Scanner;

public class SkunkApp {

	private static int POINTS_TO_WIN = 100;
	private static Round round;
	private static Scanner scanner;
	private static int totalChipsIntheKitty = 0;

	public static void main(String[] args) {

		StdOut.println("***************************************************************************");
		StdOut.println("Welcome to the Game of SKUNK! Let's play...");
		StdOut.println("***************************************************************************");

		Scanner textScan = new Scanner(System.in);

		StdOut.print("Enter Player1 name: ");
		String player1_name = textScan.nextLine();
		StdOut.print("Enter Player2 name: ");
		String player2_name = textScan.nextLine();

		Player player1 = new Player(10, player1_name);
		Player player2 = new Player(20, player2_name);

		playARound(player1, player2, POINTS_TO_WIN);
		textScan.close();
	}

	public static Player playARound(Player player1, Player player2, int goal) {
		round = new Round(player1, player2, goal);
		scanner = new Scanner(System.in);

		while (!round.isOver()) {
			playOneTurn();
		}

		printScores(player1, player2);

		StdOut.println("***************************************************************************");
		StdOut.println("           Game over! The winner is: " + round.getWinner().getName());
		StdOut.println("           You recieve: " + totalChipsIntheKitty + "Chips");
		StdOut.println("           GOODBYE... THANKS FOR PLAYING!!!                     ");
		StdOut.println("***************************************************************************");

		return round.getWinner();
	}

	private static void playOneTurn() {
		int current_chips = 0;
		StdOut.println("-------------------------------");
		StdOut.println("Now playing: " + round.currentPlayer().getName() + "...");
		StdOut.println("Total Chips in the Kitty: " + totalChipsIntheKitty + " chips");
		StdOut.println("-------------------------------");
		StdOut.println("Your total score is " + round.currentPlayer().getScore());
		StdOut.println("Your chip total is " + round.currentPlayer().getTotalChipLeft());

		while (!round.currentTurn().isOver()) {
			int turnScore = round.currentTurn().getTurnScore();
			StdOut.println("This turn's score is: " + turnScore);
			StdOut.println("Your die1: "+round.currentTurn().getDie1());
			StdOut.println("Your die2: "+round.currentTurn().getDie2());
			String userChoice = null;

			if (!isJunitTest()) {
				StdOut.println("\n");
				StdOut.println("Want to play again? (Y) or (N)");
				userChoice = scanner.nextLine();
			}

			if (isJunitTest() && turnScore >= POINTS_TO_WIN) {
				round.caskOutPoints();
			}

			if (userChoice != null && "N".equalsIgnoreCase(userChoice)) {
				round.caskOutPoints();
			} else {
				ScoreInfo scoreInfo = round.roll();
				printMessage(scoreInfo);
			}
		}
		current_chips = round.currentTurn().getTurnChipsTotal() + totalChipsIntheKitty;
		totalChipsIntheKitty = current_chips;
		if (!round.isOver()) {
			round.startNextTurn();
		}
	}

	private static void printMessage(ScoreInfo scoreInfo) {
		if (scoreInfo != null && scoreInfo.getMessage() != null) {
			StdOut.println(scoreInfo.getMessage());
		}
	}

	private static void printScores(Player player1, Player player2) {
		StdOut.println("\n");
		StdOut.println("+++++++++++++++++++++++++++++++++");
		StdOut.println("+++        Scorecard          +++");
		StdOut.println("+++++++++++++++++++++++++++++++++");
		StdOut.println("");
		StdOut.println(player1.getName() + "'s score is: " + player1.getScore());
		StdOut.println(player2.getName() + "'s score is: " + player2.getScore());
		StdOut.println("\n");
	}

	private static boolean isJunitTest() {
		boolean junitTest = false;
		if (System.getProperty("JUNIT_TEST") != null && "True".equalsIgnoreCase(System.getProperty("JUNIT_TEST"))) {
			junitTest = true;
		}
		return junitTest;
	}
}
