package system.machine;

public class MachineNotFoundException extends Exception {
	public MachineNotFoundException(String machineName) {
		super(String.format("machine \"%s\" not found in machines collection", machineName));
	}
}
