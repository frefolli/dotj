package system.machine;

import system.logging.LocalMachineLogger;

public class LocalMachine extends Machine {
	private LocalMachineLogger logger = null;

	public LocalMachine() {
		this.logger = LocalMachineLogger.getInstance();
	}

	@Override
	public void installPackage(String packageName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void uninstallPackage(String packageName) {
		// TODO Auto-generated method stub
	}

}
