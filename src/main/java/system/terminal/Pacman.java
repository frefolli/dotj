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
	public void commitInstall() {
		
	}

	@Override
	public void commitUninstall() {
		
	}
}
