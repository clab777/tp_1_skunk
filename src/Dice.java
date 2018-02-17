public final class Dice {
	private Round round;
	private RolledDie die1;
	private RolledDie die2;

	public int roll() {
		die1 = new RolledDie();
		die2 = new RolledDie();
		round = new Round();
		
        int retValue1 = round.roll(die1);
        int retValue2 = round.roll(die2);
        int roundScore = retValue1 + retValue2;
        
        return roundScore;
    }
}
