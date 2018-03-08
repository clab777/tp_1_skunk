
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TurnTest {

    private Player player;

    @Before
    public void setUp() {
         this.player = new Player(1, "Test Player");
    }

    @Test
    public void testScore_ColdStart() {
        Turn turn = makeTurnLoadedDieValue(3);
        Assert.assertEquals(0, turn.getTurnScore());
    }

    private Turn makeTurnLoadedDieValue(int value) {
        return new Turn(player, new LoadedDie(value));
    }

    @Test
    public void testEndTurn_ModifyPlayerScore() {
        Turn turn = makeTurnLoadedDieValue(4);
        turn.setTurnScore(10);
        turn.end();
        Assert.assertEquals(10, turn.getPlayer().getScore());
    }

    @Test
    public void testRoll_SkunkWithSomeScore_ResetTurnScore() {
        Turn turn = makeTurnLoadedDieValue(1);
        turn.setTurnScore(10);
        turn.roll();
        Assert.assertEquals(0, turn.getTurnScore());
    }

    @Test
    public void testIsOver_Default_False() {
        Turn turn = makeTurnLoadedDieValue(1);
        Assert.assertFalse(turn.isOver());
    }

    @Test
    public void testIsOver_After_Skunk_true() {
        Turn turn = makeTurnLoadedDieValue(1);
        turn.roll();
        Assert.assertTrue(turn.isOver());
    }

    @Test
    public void testIsOver_Afeter_Double_Skunk_true() {
        Turn turn = makeTurnLoadedDieValue(2);
        turn.roll();
        Assert.assertFalse(turn.isOver());
    }

    @Test
    public void testIsOver_EndTurn_true() {
        Turn turn = makeTurnLoadedDieValue(2);
        turn.end();
        Assert.assertTrue(turn.isOver());
    }
}
