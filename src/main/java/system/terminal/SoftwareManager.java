package system.terminal;

import java.nio.file.Files;
import java.nio.file.Path;

public abstract class SoftwareManager {
	private static SoftwareManager instance = null;
	
	public static SoftwareManager getInstance() {
		if (SoftwareManager.instance == null) {
			if (Files.exists(Path.of("/usr/bin/pacman"))) {
				SoftwareManager.instance = new Pacman();
			} else if (Files.exists(Path.of("/usr/bin/apt"))) {
				SoftwareManager.instance = new APT();
			} else if (Files.exists(Path.of("/usr/bin/dnf"))) {
				SoftwareManager.instance = new DNF();
			}
		}
		return SoftwareManager.instance;
	}
	
	protected SoftwareManager() {
		// TODO
	}
	
	public abstract void installSoftware(String software);
	
	public abstract void uninstallSoftware(String software);
}