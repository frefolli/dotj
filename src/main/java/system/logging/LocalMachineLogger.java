package system.logging;

import system.machine.LocalMachine;

public class LocalMachineLogger extends ClassLogger {
	private static LocalMachineLogger instance = null;

	private LocalMachineLogger() {
		super(LocalMachine.class);
	}
	
	public static LocalMachineLogger getInstance() {
		if (LocalMachineLogger.instance == null)
			LocalMachineLogger.instance = new LocalMachineLogger();
		return LocalMachineLogger.instance;
	}
}