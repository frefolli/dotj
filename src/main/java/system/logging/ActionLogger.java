package system.logging;

import system.action.Action;

public class ActionLogger extends ClassLogger {
	private static ActionLogger instance = null;

	private ActionLogger() {
		super(Action.class);
	}
	
	public static ActionLogger getInstance() {
		if (ActionLogger.instance == null)
			ActionLogger.instance = new ActionLogger();
		return ActionLogger.instance;
	}
}