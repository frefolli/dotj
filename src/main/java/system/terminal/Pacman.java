package system.terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.installQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			Runtime.getRuntime().exec(String.format("sudo pacman -Syu %s", String.join(" ", translatedList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void commitUninstall() {
		List<String> translatedList = new ArrayList<String>();
		for (String software : this.uninstallQueue) {
			translatedList.add(this.softwareAliases.getAlias(software));
		}
		try {
			Runtime.getRuntime().exec(String.format("sudo pacman -R %s", String.join(" ", translatedList)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
