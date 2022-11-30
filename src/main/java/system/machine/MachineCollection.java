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
		this.machines = new TreeMap<String, Machine>();
		this.logger = MachineCollectionLogger.getInstance();
	}
	
	public List<String> getListOfMachines() {
		return new ArrayList<String>(this.machines.keySet());
	}
}