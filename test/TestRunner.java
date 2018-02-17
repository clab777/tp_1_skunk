import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {



	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestSuite.class);
		for (Failure fail : result.getFailures()) {
			StdOut.println(fail.toString());
		}
		if (result.wasSuccessful()) {
			StdOut.println();
			StdOut.println();
			StdOut.println("All tests finished successfully...");
		}
	}
}
