package system.logging;

import system.machine.MachineCollection;

public class MachineCollectionLogger extends ClassLogger {
	private static MachineCollectionLogger instance = null;

	private MachineCollectionLogger() {
		super(MachineCollection.class);
	}
	
	public static MachineCollectionLogger getInstance() {
		if (MachineCollectionLogger.instance == null)
			MachineCollectionLogger.instance = new MachineCollectionLogger();
		return MachineCollectionLogger.instance;
	}
}
