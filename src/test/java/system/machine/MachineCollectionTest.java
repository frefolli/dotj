package system.machine;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MachineCollectionTest {
	public MachineCollection craftSampleMachineCollection() {
		MachineCollection machineCollection = new MachineCollection();
		return machineCollection;
	}
	
	@Test
	public void testConstructor() {
		MachineCollection machineCollection = this.craftSampleMachineCollection();
		assertEquals(machineCollection.getListOfMachines().size(), 0);
	}
	
	@Test
	public void testGet() {
		MachineCollection machineCollection = this.craftSampleMachineCollection();
		try {
			machineCollection.getMachine("1");
			fail("should not be able to get machine");
		} catch (MachineNotFoundException e) {}
		try {
			machineCollection.addMachine("1", new LocalMachine());
		} catch (MachineAlreadyInCollectionException e) {
			fail("should be able to add machine");
		}
		try {
			machineCollection.getMachine("1");
		} catch (MachineNotFoundException e) {
			fail("should be able to get machine");
		}
	}
	
	@Test
	public void testAdd() {
		MachineCollection machineCollection = this.craftSampleMachineCollection();
		try {
			machineCollection.addMachine("1", new LocalMachine());
		} catch (MachineAlreadyInCollectionException e) {
			fail("should be able to add machine");
		}
		try {
			machineCollection.addMachine("1", new LocalMachine());
			fail("should not be able to add machine");
		} catch (MachineAlreadyInCollectionException e) {}
	}
	
	@Test
	public void testRemove() {
		MachineCollection machineCollection = this.craftSampleMachineCollection();
		try {
			machineCollection.addMachine("1", new LocalMachine());
		} catch (MachineAlreadyInCollectionException e) {
			fail("should be able to add machine");
		}
		try {
			machineCollection.removeMachine("1");
		} catch (MachineNotFoundException e) {
			fail("should be able to remove machine");
		}
		try {
			machineCollection.removeMachine("1");
			fail("should not be able to remove machine");
		} catch (MachineNotFoundException e) {}
	}
}
