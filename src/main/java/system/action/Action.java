package system.action;
import java.util.Objects;

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
	
	public int hashCode() {
		return this.command.hashCode();
	}

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Action)) {
			return false;
		}
		Action other = (Action) obj;
		return Objects.equals(command, other.command);
	}
}