public final class Player {

	private String name;
    private int score;
    private int id;
    private int chips;
    private int CHIP_MAX = 50;
    
    
    public Player(int id, String name) {
    	this.id = id;
        this.name = name;
        this.chips = CHIP_MAX;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return this.score;
    }

    public String getName() {
        return name;
    }
    
    public int getId(){
    	return id;
    }
    
    public void drawsChip(int draw_chips)
    {
    		this.chips -= draw_chips;
    }
    
    public int getTotalChipLeft()
    {
    		return chips;
    }
}
