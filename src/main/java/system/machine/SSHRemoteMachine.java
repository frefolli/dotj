package system.machine;

import system.logging.SSHRemoteMachineLogger;

public class SSHRemoteMachine extends Machine {
	private SSHRemoteMachineLogger logger = null;

	public SSHRemoteMachine() {
		this.logger = SSHRemoteMachineLogger.getInstance();
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