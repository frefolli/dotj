package system.machine;

import org.junit.Test;

public class LocalMachineTest {
	public LocalMachine craftSampleLocalMachine() {
		LocalMachine localMachine = new LocalMachine();
		return localMachine;
	}
	
	@Test
	public void testConstructor() {
		LocalMachine localMachine = this.craftSampleLocalMachine();
	}
	
	@Test
	public void testInstall() {
		LocalMachine localMachine = this.craftSampleLocalMachine();
		localMachine.installPackage("dummy");
	}
	
	@Test
	public void testUninstall() {
		LocalMachine localMachine = this.craftSampleLocalMachine();
		localMachine.uninstallPackage("dummy");
	}
}
