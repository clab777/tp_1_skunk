
public final class Turn {

    private static final int SKUNK = 1;
    private Player player;
    private Die die;
    private int turnScore = 0;
    private boolean isOver = false;
    private ScoreInfo scoreInfo;
    
    public Turn(Player player, Die die) {
        this.player = player;
        this.die = die;
    }

    public int getTurnScore() {
        return turnScore;
    }

    public ScoreInfo roll() {
        int roll1 = die.roll();
        int roll2 = die.roll();
        int result = 0;
        
        scoreInfo = new ScoreInfo();
        Chips chips = new Chips();
        
        if(roll1 == SKUNK && roll2 == SKUNK){ 
            turnScore = 0; 
            scoreInfo.setScore(turnScore);
            scoreInfo.setMessage("You got ***double skunk***. You rolled: " +roll1+ ", " +roll2 + " \nYou lose all your points for this round and your total points!");
            chips.recieves2Skunk();
            isOver = true;
        }else if (roll1 == SKUNK || roll2 == SKUNK) {
            turnScore = 0;
            scoreInfo.setScore(turnScore);
            scoreInfo.setMessage("You got a ***skunk***.  You rolled: " +roll1+ ", " +roll2 + " \nYou lose all your points for this round and your total points!");
            chips.recievesSkunk();
            isOver = true;
        }else {
        	result = roll1 + roll2;
            turnScore += result;
            
            scoreInfo.setScore(turnScore);
        }
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
}
