import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoundTest {


    private Player player1;
    private Player player2;
    private Round round;
    private int POINTS_TO_WIN = 100;

    @Before
    public void setUp() {
        player1 = new Player(1, "Christophe");
        player2 = new Player(2, "Sinith");
        round = new Round(player1, player2, POINTS_TO_WIN);
    }

    @Test
    public void testCurrentPlayerIsPlayer_1() {
        Assert.assertEquals(player1, round.currentPlayer());
    }

    @Test
    public void testStartNextTurn() {
        round.startNextTurn();
        Assert.assertEquals(player2, round.currentPlayer());
    }

    @Test
    public void testIsOver_Initial() {
        Assert.assertFalse(round.isOver());
    }

    @Test
    public void testIsOver_Player_1_HasMaxPoints() {
        player1.setScore(POINTS_TO_WIN);
        round.caskOutPoints();
        Assert.assertTrue(round.isOver());
    }

    @Test
    public void testGetWinner_Player_1_HasMaxPoints() {
        player1.setScore(POINTS_TO_WIN);
        round.caskOutPoints();
        Assert.assertEquals(player1, round.getWinner());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetWinner_When_No_Winner() {
        round.getWinner();
    }
}
