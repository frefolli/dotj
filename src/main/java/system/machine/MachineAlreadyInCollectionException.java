package system.machine;

public class MachineAlreadyInCollectionException extends Exception {
	public MachineAlreadyInCollectionException(String machineName) {
		super(String.format("machine \"%s\" already in machines collection", machineName));
	}
}
