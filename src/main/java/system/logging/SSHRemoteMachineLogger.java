package system.logging;

import system.machine.SSHRemoteMachine;

public class SSHRemoteMachineLogger extends ClassLogger {
	private static SSHRemoteMachineLogger instance = null;

	private SSHRemoteMachineLogger() {
		super(SSHRemoteMachine.class);
	}
	
	public static SSHRemoteMachineLogger getInstance() {
		if (SSHRemoteMachineLogger.instance == null)
			SSHRemoteMachineLogger.instance = new SSHRemoteMachineLogger();
		return SSHRemoteMachineLogger.instance;
	}
}
