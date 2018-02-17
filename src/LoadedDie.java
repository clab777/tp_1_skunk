public class LoadedDie implements Die {
	
    private final int value;

    public LoadedDie(int value) {
        this.value = value;
    }

    @Override
    public int roll() {
        return value;
    }

}
