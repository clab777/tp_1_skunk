public class Die {

	private final static int NUMBER_OF_SIDES = 6;
	private int dieRoll;

	public int getDieRoll() {
		return dieRoll;
	}


	public Die(){
		
	}
	
	public Die(int value){
		this.dieRoll = value;
	}
	
	
	/**
	 * The roll method rolls a six-sided die
	 * 
	 * @return the value of the die, an integer value between [1-6] inclusive
	 */
	public int roll() {
		dieRoll = (int) ((Math.random() * NUMBER_OF_SIDES) +1);
		return dieRoll;
	}
	
	/**
	 * The roll method rolls a "loaded" die
	 * 
	 * @return the loaded value of the die
	 */
	public int roll(int value) {
		return dieRoll;
	}	
	
}
