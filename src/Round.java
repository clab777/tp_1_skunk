public class Round {

    private static final Die DIE = new RolledDie();

    private final Player player1;
    private final Player player2;
    private Player winner;
    private boolean isOver = false;
    private Turn turn;
	private int pointsToWin;

    public Round(Player player1, Player player2, int nbPoints) {
        this.player1 = player1;
        this.player2 = player2;
        this.pointsToWin = nbPoints;
        this.turn = new Turn(player1, DIE);
    }

    public Player currentPlayer() {
        return turn.getPlayer();
    }

	public void caskOutPoints() {
        turn.end();
        if (currentPlayer().getScore() >= pointsToWin) {
            this.winner = currentPlayer();
            this.isOver = true;
        }
    }

    public void startNextTurn() {
        turn = new Turn(nextPlayer(), DIE);
    }

    private Player nextPlayer() {
        return currentPlayer().equals(player1) ? player2 : player1;
    }

    public boolean isOver() {
        return isOver;
    }

    public Player getWinner() {
        if (!isOver()) {
            throw new IllegalStateException("The game is not over");
        } else {
            return winner;
        }
    }

    public ScoreInfo roll() {
        return turn.roll();
    }

    public Turn currentTurn() {
        return turn;
    }
    
}
