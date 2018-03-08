public final class Dice {
	private RolledDie die1;
	private RolledDie die2;

	public int roll() {
		die1 = new RolledDie();
		die2 = new RolledDie();
		
        int retValue1 = die1.roll();
        int retValue2 = die2.roll();
        int roundScore = retValue1 + retValue2;
        
        return roundScore;
    }
}
