
public final class Turn {

    private static final int SKUNK = 1;
    private static final int DEUCE = 2;
    private Player player;
    private Die die;
    private int turnScore = 0;
    private boolean isOver = false;
    private ScoreInfo scoreInfo;
    private int totalChips = 0;
    private int roll1;
    private int roll2;
    
    public Turn(Player player, Die die) {
        this.player = player;
        this.die = die;
        roll1 = 0;
        roll2 = 0;
    }

    public int getTurnScore() {
        return turnScore;
    }

    public ScoreInfo roll() {
        roll1 = die.roll();
        roll2 = die.roll();
        int result = 0;
        
        scoreInfo = new ScoreInfo();
        Chips chips = new Chips();
        
        if(roll1 == SKUNK && roll2 == SKUNK){ 
            turnScore = 0; 
            scoreInfo.setScore(turnScore);
            scoreInfo.setMessage("You got ***double skunk***. You rolled: " +roll1+ ", " +roll2 + " \nYou lose all your points for this round and your total points!");
            chips.recieves2Skunk();
            this.player.drawsChip(4);
            isOver = true;
        }else if ((roll1 == SKUNK && roll2 != DEUCE) || (roll2 == SKUNK && roll1 != DEUCE)) {
            turnScore = 0;
            scoreInfo.setScore(turnScore);
            scoreInfo.setMessage("You got a ***skunk***.  You rolled: " +roll1+ ", " +roll2 + " \nYou lose all your points for this round and your total points!");
            chips.recievesSkunk();
            this.player.drawsChip(1);
            isOver = true;
        }else if ((roll1 == SKUNK && roll2 == DEUCE) || (roll2 == SKUNK && roll1 == DEUCE)){
            turnScore = 0;
            scoreInfo.setScore(turnScore);
            scoreInfo.setMessage("You got a ***skunk and a deuce***.  You rolled: " +roll1+ ", " +roll2 + " \nYou lose all your points for this round and your total points!");
            chips.recieves1Skunkand1Deuce();
            this.player.drawsChip(2);
            isOver = true;
        }else {
        	result = roll1 + roll2;
            turnScore += result;
            
            scoreInfo.setScore(turnScore);
        }
        totalChips = chips.getTotalChips();
        return scoreInfo; 
    }

    public void setTurnScore(int score) {
        this.turnScore = score;
    }

    public void end() {
        this.player.setScore(player.getScore() + this.turnScore);
        this.isOver = true;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isOver() {
        return isOver;
    }
    
    public int getTurnChipsTotal() {
    		return this.totalChips;
    }
    
    public int getDie1()
    {
    		return roll1;
    }
    
    public int getDie2()
    {
    		return roll2;
    }
}
