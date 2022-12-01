package system.action;

import java.util.ArrayList;
import java.util.List;
import system.logging.ScriptLogger;

public class Script {
	private List<Action> actions = null;
	private ScriptLogger logger = null;

	public Script(List<Action> actions) {
		this.actions = actions;
		this.logger = ScriptLogger.getInstance();
	}

	public Script() {
		this(new ArrayList<>());
	}
	
	public void run() {
		for(Action action : this.actions) {
			action.run();
		}
	}
	
	public List<Action> getActions() {
		return new ArrayList<>(this.actions);
	}
	
	public int getNumberOfActions() {
		return this.actions.size();
	}
	
	public Action getAction(int index) {
		return this.actions.get(index);
	}
	
	public void appendAction(Action action) throws ActionAlreadyInScriptException {
		if (this.actions.contains(action)) {
			throw new ActionAlreadyInScriptException(action);
		} else {
			this.actions.add(action);
		}
	}
	
	public void removeAction(Action action) throws ActionNotFoundException {
		if (this.actions.contains(action)) {
			this.actions.remove(action);
		} else {
			throw new ActionNotFoundException(action);
		}
	}
}