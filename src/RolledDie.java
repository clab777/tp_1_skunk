import java.util.Random;

public class RolledDie implements Die {
	private final static int NUMBER_OF_SIDES = 6;
	
    private static final Random RANDOM = new Random();

    @Override
    public int roll() {
        return RANDOM.nextInt(NUMBER_OF_SIDES) + 1;
    }
}