import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import junit.framework.TestCase;

@RunWith(Suite.class)
@Suite.SuiteClasses( { DiceTest.class, DieTest.class, SkunkAppTest.class, RoundTest.class })
public class TestSuite extends TestCase {

}
