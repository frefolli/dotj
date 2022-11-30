package system.machine;

import org.junit.Test;

public class SSHRemoteMachineTest {
	public SSHRemoteMachine craftSampleSSHRemoteMachine() {
		SSHRemoteMachine remoteMachine = new SSHRemoteMachine();
		return remoteMachine;
	}
	
	@Test
	public void testConstructor() {
		SSHRemoteMachine remoteMachine = this.craftSampleSSHRemoteMachine();
	}
	
	@Test
	public void testInstall() {
		SSHRemoteMachine remoteMachine = this.craftSampleSSHRemoteMachine();
		remoteMachine.installPackage("dummy");
	}
	
	@Test
	public void testUninstall() {
		SSHRemoteMachine remoteMachine = this.craftSampleSSHRemoteMachine();
		remoteMachine.uninstallPackage("dummy");
	}
}