package system.logging;

import system.action.Script;

public class ScriptLogger extends ClassLogger {
	private static ScriptLogger instance = null;

	private ScriptLogger() {
		super(Script.class);
	}
	
	public static ScriptLogger getInstance() {
		if (ScriptLogger.instance == null)
			ScriptLogger.instance = new ScriptLogger();
		return ScriptLogger.instance;
	}
}
