package system.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import system.logging.MachineCollectionLogger;

public class MachineCollection {
	private MachineCollectionLogger logger = null;
	private Map<String, Machine> machines = null;

	public MachineCollection() {
		this.machines = new TreeMap<>();
		this.logger = MachineCollectionLogger.getInstance();
	}
	
	public List<String> getListOfMachines() {
		return new ArrayList<>(this.machines.keySet());
	}
	
	public Machine getMachine(String machineName) throws MachineNotFoundException {
		if (this.machines.containsKey(machineName)) {
			return this.machines.get(machineName);
		} else {
			throw new MachineNotFoundException(machineName);
		}
	}
	
	public void addMachine(String machineName, Machine machine) throws MachineAlreadyInCollectionException {
		if (this.machines.containsKey(machineName)) {
			throw new MachineAlreadyInCollectionException(machineName);
		} else {
			this.machines.put(machineName, machine);
		}
	}
	
	public void removeMachine(String machineName) throws MachineNotFoundException {
		if (this.machines.containsKey(machineName)) {
			this.machines.remove(machineName);
		} else {
			throw new MachineNotFoundException(machineName);
		}
	}
}