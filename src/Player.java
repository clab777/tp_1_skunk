public final class Player {

	private String name;
    private int score;
    private int id;
    
    
    public Player(int id, String name) {
    	this.id = id;
        this.name = name;
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
}
