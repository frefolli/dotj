package system.terminal;

public class Pacman extends SoftwareManager {
	private static Pacman instance = null;
	private SoftwareAliases softwareAliases = null;
	
	public static Pacman getInstance() {
		if (Pacman.instance == null)
			Pacman.instance = new Pacman();
		return Pacman.instance;
	}
	
	protected Pacman() {
		this.softwareAliases = new SoftwareAliases();
	}

	@Override
	public void installSoftware(String software) {
		// TODO Auto-generated method stub
	}

	@Override
	public void uninstallSoftware(String software) {
		// TODO Auto-generated method stub
	}
}
