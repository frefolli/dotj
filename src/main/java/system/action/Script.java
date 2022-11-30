package system.action;

import java.util.ArrayList;
import java.util.List;
import system.logging.ScriptLogger;

public class Script {
	private List<Action> actions = null;
	private ScriptLogger logger = null;

	public Script() {
		this.actions = new ArrayList<Action>();
		this.logger = ScriptLogger.getInstance();
	}
	
	public void run() {
		for(Action action : this.actions) {
			action.run();
		}
	}
}
