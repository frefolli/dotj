package system.action;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ActionTest {
	@Test
	public void testConstructor() {
		String command = "ls /tmp";
		Action action = new Action(command);
		assertEquals(action.getCommand(), command);
	}
	
	@Test
	public void testRun() {
		String command = "ls /tmp";
		Action action = new Action(command);
		action.run();
	}
}