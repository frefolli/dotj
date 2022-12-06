package system.terminal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a Unit of Work, at a certain time commit() is called
 * So i only need to register actions and override only commit phases
 * 
 * This is also a Template Method implementation, commit calls
 * commitInstall and commitUninstall, which are overridden by subclasses
 * */
public abstract class SoftwareManager {
	private static SoftwareManager instance = null;
	protected List<String> installQueue = null;
	protected List<String> uninstallQueue = null;
	
	public static SoftwareManager getInstance() {
		if (SoftwareManager.instance == null) {
			if (Files.exists(Path.of("/usr/bin/yay"))) {
				SoftwareManager.instance = new Yay();
			} else if (Files.exists(Path.of("/usr/bin/pacman"))) {
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
		this.installQueue = new ArrayList<String>();
		this.uninstallQueue = new ArrayList<String>();
	}
	
	public void installSoftware(String software) {
		this.installQueue.add(software);
	}
	
	public void uninstallSoftware(String software) {
		this.uninstallQueue.add(software);
	}
	
	public void commit() {
		this.commitInstall();
		this.commitUninstall();
	}
	
	public abstract void commitInstall();
	public abstract void commitUninstall();
}