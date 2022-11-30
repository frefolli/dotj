package system.action;

public class ActionNotFoundException extends Exception {
	public ActionNotFoundException(Action action) {
		super(String.format("action \"%s\" not in script", action.getCommand()));
	}
}
