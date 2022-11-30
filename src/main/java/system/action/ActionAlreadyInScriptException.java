package system.action;

public class ActionAlreadyInScriptException extends Exception {
	public ActionAlreadyInScriptException(Action action) {
		super(String.format("action \"%s\" already in script", action.getCommand()));
	}

}
