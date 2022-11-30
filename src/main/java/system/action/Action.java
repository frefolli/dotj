package system.action;
import system.logging.ActionLogger;

public class Action {
	private String command = null;
	private ActionLogger logger = null;

	public Action(String command) {
		this.command = command;
		this.logger = ActionLogger.getInstance();
	}

	public void run() {
		// TODO implementation
	}
	
	public String getCommand() {
		return this.command;
	}
}
