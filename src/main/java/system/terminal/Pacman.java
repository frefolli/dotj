package system.terminal;

public class Pacman extends SoftwareManager {
	private static Pacman instance = null;
	
	public static Pacman getInstance() {
		if (Pacman.instance == null)
			Pacman.instance = new Pacman();
		return Pacman.instance;
	}
	
	protected Pacman() {
		super(new SoftwareAliases(), "pacman", "-Syu --needed --noconfirm", "-R", true);
	}
}
