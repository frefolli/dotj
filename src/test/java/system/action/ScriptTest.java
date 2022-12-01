package system.action;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ScriptTest {
	@Test
	public void testEmptyConstructor() {
		Script script = new Script();
		assertEquals(0, script.getNumberOfActions());
	}
	
	@Test
	public void testConstructor() {
		List<Action> actions = new ArrayList<Action>();
		Script script = new Script();
		assertEquals(actions, script.getActions());
		Action action = new Action("ls");
		try {
			script.appendAction(action);
		} catch(ActionAlreadyInScriptException error) {
			fail("should be able to add action");
		}
		assertTrue(script.getActions().contains(action));
		assertEquals(1, script.getNumberOfActions());
		assertEquals(action, script.getAction(0));
		try {
			script.removeAction(action);
			assertTrue(!(script.getActions().contains(action)));
		} catch(ActionNotFoundException error) {
			fail("should be able to remove action");
		}
	}
	
	@Test
	public void testRemoveActionException() {
		List<Action> actions = new ArrayList<Action>();
		Script script = new Script();
		Action action = new Action("ps");
		try {
			script.removeAction(action);
			fail("should not be able to remove action");
		} catch(ActionNotFoundException error) {}
	}
	
	@Test
	public void testAppendActionException() {
		List<Action> actions = new ArrayList<Action>();
		Script script = new Script();
		Action action = new Action("ps");
		try {
			script.appendAction(action);
		} catch(ActionAlreadyInScriptException error) {
			fail("should be able to add action");
		}
		try {
			script.appendAction(action);
			fail("should not be able to add action twice");
		} catch(ActionAlreadyInScriptException error) {}
	}
	
	@Test
	public void testRun() {
		Script script = new Script();
		try {
			script.appendAction(new Action("ls"));
		} catch(ActionAlreadyInScriptException error) {
			fail("should be able to add action");
		}
		script.run();
	}
}
