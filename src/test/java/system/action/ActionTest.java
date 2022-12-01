package system.action;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

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
	
	@Test
	public void testEquals() {
		Action A = new Action("A");
		Action B = new Action("B");
		Action A2 = new Action("A");
		assertEquals(A,A);
		assertNotEquals(A,B);
		assertEquals(A,A2);
		assertNotEquals(A, new Script());
	}

	@Test
	public void testHashCode() {
		Action A = new Action("A");
		Action B = new Action("B");
		Action A2 = new Action("A");
		assertEquals(A.hashCode(), A.hashCode());
		assertNotEquals(A.hashCode(), B.hashCode());
		assertEquals(A.hashCode(), A2.hashCode());
	}
}